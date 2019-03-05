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
        val prevList = prev.fullNodes()
        val nextList = next.fullNodes()
        val minSynonymPathIndex = min(prevList.lastIndex, nextList.lastIndex)
        val commonAncestorIndex: Int = (0..minSynonymPathIndex).lastOrNull {
            prevList[it] == nextList[it]
        } ?: minSynonymPathIndex

        prevList.subList(commonAncestorIndex, prevList.size).apply {
            if (this.size > 1) {
                this.windowed(2, 1, partialWindows = true).forEach { pair ->
                    GlobalScope.launch(Dispatchers.Main) {
                        val child: Route? = pair.getOrNull(1)
                        pair[0].component.onSwapOutChild(child?.name, child?.component)
                    }.join()
                }
            }
        }

        nextList.subList(commonAncestorIndex, nextList.size).apply {
            if (this.size > 1) {
                this.windowed(2, 1, partialWindows = true).forEach { pair ->
                    GlobalScope.launch(Dispatchers.Main) {
                        val child: Route? = pair.getOrNull(1)
                        pair[0].component.onSwapInChild(child?.name, child?.component, emptyMap())
                    }.join()
                }
            }
        }
    }

    companion object {
        operator fun invoke(cb: ChildrenBuilder.() -> Unit): KoRouter {
            val builder = ChildrenBuilder(cb)
            return KoRouter(builder.build())
        }
    }

    class ChildrenBuilder {
        private val routes: MutableList<Route> = mutableListOf()

        fun route(path: String, cb: RouteBuilder.() -> Unit) {
            routes.add(RouteBuilder(path, cb).build())
        }

        fun build(): MutableList<Route> = routes

        companion object {
            operator fun invoke(cb: ChildrenBuilder.() -> Unit): ChildrenBuilder {
                return ChildrenBuilder().apply(cb)
            }
        }
    }

    class RouteBuilder {
        lateinit var path: String
        lateinit var name: String
        lateinit var component: Presenter
        private var children: MutableList<Route>? = null

        fun children(cb: ChildrenBuilder.() -> Unit) {
            children = ChildrenBuilder(cb).build()
        }

        fun build(): Route = Route(
            path = path,
            name = name,
            component = component,
            children = children
        )

        companion object {
            operator fun invoke(path: String, cb: RouteBuilder.() -> Unit): RouteBuilder {
                return RouteBuilder().apply {
                    this.path = path
                    this.cb()
                }
            }
        }
    }
}
