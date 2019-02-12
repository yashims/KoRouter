package me.yashims85.korouter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.math.min

class KoRouter(routes: List<Route>) {

    private val matcher: Matcher = Matcher(routes)
    private val history: History = History()
    private var currentRoute: Route = matcher.root()

    fun push(location: String) {
        history.push(location)
        val prevRoute = currentRoute
        currentRoute = matcher.match(location)
        differDispatch(prevRoute, currentRoute)
    }

    fun back() {
        val location = history.back()
        val prevRoute = currentRoute
        currentRoute = matcher.match(location)
        differDispatch(prevRoute, currentRoute)
    }

    fun forward() {
        val location = history.forward()
        val prevRoute = currentRoute
        currentRoute = matcher.match(location)
        differDispatch(prevRoute, currentRoute)
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        matcher.addChildren(parentLocation, children)
    }

    fun differDispatch(prev: Route, next: Route) {
        val (prevList, nextList) = prev.fullNodes() to next.fullNodes()
        val minSynonymPathIndex = min(prevList.lastIndex, nextList.lastIndex)
        val commonAncestorIndex: Int = (0..minSynonymPathIndex).lastOrNull {
            prevList[it] == nextList[it]
        } ?: minSynonymPathIndex

        prevList.subList(commonAncestorIndex, prevList.size).apply {
            if (this.size > 1) {
                reduce { parent, child ->
                    parent.component.onSwapOutChild(child.name, child.component)
                    child
                }
            }
        }

        nextList.subList(commonAncestorIndex, nextList.size).apply {
            if (this.size > 1) {
                reduce { parent, child ->
                    parent.component.onSwapInChild(child.name, child.component, emptyMap())
                    child
                }
            }
        }
    }
}
