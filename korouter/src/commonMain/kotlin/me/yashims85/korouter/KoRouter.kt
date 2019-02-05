package me.yashims85.korouter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.math.max

class KoRouter(private val routes: List<Route>) {

    private val matcher: Matcher = Matcher(routes)
    private val history: History = History()
    private var currentRoute: List<Route> = emptyList()

    fun push(location: String) = GlobalScope.async {
        history.push(location)
        val routes = matcher.match(location)
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        matcher.addChildren(parentLocation, routes)
    }

    fun differDispatch(prev: List<Route>, next: List<Route>) {
        val swapOutList: MutableList<Route> = mutableListOf()
        val swapInList: MutableList<Route> = mutableListOf()
        (0..max(prev.lastIndex, next.lastIndex)).forEach {
            if (prev[it] != next[it]) {
                swapOutList.add(prev[it])
                swapInList.add(next[it])
            }
        }
    }
}
