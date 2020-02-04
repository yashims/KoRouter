package dev.yashims.korouter

import dev.yashims.korouter.matcher.RouterMatchResult
import me.yashims.util.Log
import kotlin.math.min

class KoRouter(routes: List<Route>) {

    private val matcher: Matcher = Matcher(routes)
    private val history: History = History()
    var currentRoute: Route = matcher.root()
        private set

    fun push(location: String) {
        Log.d("push")
        history.push(location)
        val prevRoute = currentRoute
        val matches: RouterMatchResult = matcher.match(location)
        currentRoute = matches.route
        differDispatch(prevRoute, currentRoute, matches.param)
    }

    fun replace(location: String) {
        history.replace(location)
        val prevRoute = currentRoute
        val matches: RouterMatchResult = matcher.match(location)
        currentRoute = matches.route
        differDispatch(prevRoute, currentRoute, matches.param)
    }

    fun back() {
        val location = history.back()
        val prevRoute = currentRoute
        val matches: RouterMatchResult = matcher.match(location)
        currentRoute = matches.route
        differDispatch(prevRoute, currentRoute, matches.param)
    }

    fun forward() {
        val location = history.forward()
        val prevRoute = currentRoute
        val matches: RouterMatchResult = matcher.match(location)
        currentRoute = matches.route
        differDispatch(prevRoute, currentRoute, matches.param)
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        matcher.addChildren(parentLocation, children)
    }

    private fun differDispatch(prev: Route, next: Route, params: Map<String, String>?) {
        val prevList = prev.fullNodes()
        val nextList = next.fullNodes()
        val minSynonymPathIndex = min(prevList.lastIndex, nextList.lastIndex)

        // idx[0] is dummy root node. it defined in Matcher
        val commonAncestorIndex: Int = (0..minSynonymPathIndex).lastOrNull {
            prevList[it] == nextList[it]
        } ?: 0

        prevList.subList(commonAncestorIndex, prevList.size).apply {
            if (this.size > 1) {
                // Swap-out call ordered by child to parent.
                this.windowed(2, 1, partialWindows = true).reversed().forEach { pair ->
                    val child: Route? = pair.getOrNull(1)
                    pair[0].component.onSwapOutChild(child?.name, child?.component)
                }
            }
        }

        nextList.subList(commonAncestorIndex, nextList.size).apply {
            if (this.size > 1) {
                // Swap-in call ordered by parent to child.
                this.windowed(2, 1, partialWindows = true).forEach { pair ->
                    val parent: Route = pair[0]
                    val child: Route? = pair.getOrNull(1)

                    // Case of node is internal node in subtree
                    parent.component.onSwapInChild(child?.name, child?.component, params)
                }
            }
        }
    }

    constructor(block: ChildrenBuilder.() -> Unit) : this(ChildrenBuilder(block).build())

    companion object {
        fun chant() {}
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

