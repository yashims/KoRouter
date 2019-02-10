package me.yashims85.korouter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import me.yashims85.util.Log
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

    fun back() = GlobalScope.async {
        val location = history.back()
        val prevRoute = currentRoute
        currentRoute = matcher.match(location)
        differDispatch(prevRoute, currentRoute)
    }

    fun forward() = GlobalScope.async {
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
        Log.d("KoRouter@differ prev(${prevList.size}): ${prevList} next(${nextList.size}): ${nextList}")
        val minSynonymPathIndex = min(prevList.lastIndex, nextList.lastIndex)
        val commonAncestorIndex: Int = (0..minSynonymPathIndex).lastOrNull {
            prevList[it] == nextList[it]
        } ?: minSynonymPathIndex
        Log.d("KoRouter@differ minSynonym: ${minSynonymPathIndex} commonAncIdx: ${commonAncestorIndex}")

        prevList.subList(commonAncestorIndex, prevList.size).apply {
            Log.d("KoRouter@differ swapout prev(${this.size}): ${this}")
            if (this.size > 1) {
                reduce { parent, child ->
                    Log.d("KoRouter@differ swap out: ${child}")
                    parent.component.onSwapOutChild(child.name, child.component)
                    child
                }
            }
        }

        nextList.subList(commonAncestorIndex, nextList.size).apply {
            Log.d("KoRouter@differ swapin prev(${this.size}): ${this}")
            if (this.size > 1) {
                reduce { parent, child ->
                    Log.d("KoRouter@differ swap in: ${child}")
                    parent.component.onSwapInChild(child.name, child.component, emptyMap())
                    child
                }
            }
        }
    }
}
