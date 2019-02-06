package me.yashims85.korouter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.math.min

class KoRouter(routes: List<Route>) {

    private val matcher: Matcher = Matcher(routes)
    private val history: History = History()
    private var currentRoute: Route = matcher.root()

    fun push(location: String) = GlobalScope.async {
        history.push(location)
        val route = matcher.match(location)
        differDispatch(currentRoute, route)
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        matcher.addChildren(parentLocation, children)
    }

    fun differDispatch(prev: Route, next: Route) {
        val (prevList, nextList) = prev.fullNodes() to next.fullNodes()
        val maxSynonymPathHeight = min(prevList.lastIndex, nextList.lastIndex)
        val commonAncestorIndex: Int = (0..maxSynonymPathHeight).lastOrNull {
            prevList[it] == nextList[it]
        } ?: maxSynonymPathHeight

        prevList.subList(commonAncestorIndex, prevList.lastIndex).reduce { parent, child ->
            parent.component.onSwapOutChild(child.name, child.component)
            child
        }

        nextList.subList(commonAncestorIndex, nextList.lastIndex).reduce { parent, child ->
            parent.component.onSwapInChild(child.name, child.component, emptyMap())
            child
        }
    }
}
