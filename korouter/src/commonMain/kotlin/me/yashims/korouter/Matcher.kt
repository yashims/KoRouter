package me.yashims.korouter

import me.yashims.korouter.matcher.RouterMatchResult

class Matcher(routes: List<Route>) {

    private val tree: Route = Route("", "", object : Presenter {
        override fun onSwapInChild(name: String?, child: Presenter?, args: Map<String, String>?) {}

        override fun onSwapOutChild(name: String?, child: Presenter?) {}
    })

    private val locationMatcher: Regex = Regex("""^/?:([^/]+)""")

    init {
        addChildren(tree, routes, replaceChildren = true)
    }

    fun root(): Route = tree

    fun addChildren(parent: Route, children: List<Route>, replaceChildren: Boolean = false) {
        if (parent.children == null || replaceChildren) {
            parent.children = mutableListOf()
        }

        parent.children?.apply {
            children.forEach {
                it.parent = parent
                it.children?.let { nextGenChildren ->
                    addChildren(it, nextGenChildren)
                }
            }
            addAll(children)
        }
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        addChildren(match(parentLocation).route, children)
    }

    fun match(location: String, route: Route = tree): RouterMatchResult {
        val splitList = location.split('/', limit = 2)
        var locationSlice = splitList.getOrElse(0) { "" }
        var nextLocation = splitList.getOrElse(1) { "" }

        // if current location is blank avoid current location slice.
        if (locationSlice.isBlank() && nextLocation.isNotBlank()) {
            return match(nextLocation, route)
        }

        if (locationSlice.isBlank()) {
            locationSlice = "/"
        }

        // Search matched node in children
        val matchNode: RouterMatchResult? = route.children?.run {
            var param: Map<String, String>? = null
            firstOrNull {
                if (it.path == locationSlice || it.path.isBlank()) {
                    return@firstOrNull true
                }

                locationMatcher.matchEntire(it.path)?.let { result: MatchResult ->
                    param = mapOf(result.destructured.component1() to locationSlice)
                    return@firstOrNull true
                }
                false
            }?.let {
                RouterMatchResult(it, param)
            }

        }
        return matchNode?.let {
            when {
                // Case of abstract inner node.(everything blank match)
                it.route.path.isBlank() -> match(location, it.route).copy(param = it.param)
                // Case of inner node.
                nextLocation.isNotBlank() -> match(nextLocation, it.route).copy(param = it.param)
                // Case of leaf node.
                else -> it
            }
        } ?: throw RouteNotMatchException("No matching $location in ${route.fullPath()} children")
    }
}