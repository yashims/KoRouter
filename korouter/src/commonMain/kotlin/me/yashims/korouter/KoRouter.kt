package me.yashims.korouter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.min

class KoRouter(routes: List<Route>) {

    private val matcher: Matcher = Matcher(routes)
    private val history: History = History()
    private var currentRoute: Route = matcher.root()

    fun push(location: String) {
        GlobalScope.launch {
            history.push(location)
            val prevRoute = currentRoute
            currentRoute = matcher.match(location)
            differDispatch(prevRoute, currentRoute)
        }
    }

    fun back() {
        GlobalScope.launch {
            val location = history.back()
            val prevRoute = currentRoute
            currentRoute = matcher.match(location)
            differDispatch(prevRoute, currentRoute)
        }
    }

    fun forward() {
        GlobalScope.launch {
            val location = history.forward()
            val prevRoute = currentRoute
            currentRoute = matcher.match(location)
            differDispatch(prevRoute, currentRoute)
        }
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        matcher.addChildren(parentLocation, children)
    }

    private suspend fun differDispatch(prev: Route, next: Route) {
        val (prevList, nextList) = prev.fullNodes() to next.fullNodes()
        val minSynonymPathIndex = min(prevList.lastIndex, nextList.lastIndex)
        val commonAncestorIndex: Int = (0..minSynonymPathIndex).lastOrNull {
            prevList[it] == nextList[it]
        } ?: minSynonymPathIndex

        prevList.subList(commonAncestorIndex, prevList.size).apply {
            if (this.size > 1) {
                this.windowed(2).forEach { (parent: Route, child: Route) ->
                    GlobalScope.launch(Dispatchers.Main) {
                        parent.component.onSwapOutChild(child.name, child.component)
                    }.join()
                }
            }
        }

        nextList.subList(commonAncestorIndex, nextList.size).apply {
            if (this.size > 1) {
                this.windowed(2).forEach { (parent: Route, child: Route) ->
                    GlobalScope.launch(Dispatchers.Main) {
                        parent.component.onSwapInChild(child.name, child.component, emptyMap())
                    }.join()
                }
            }
        }
    }
}
