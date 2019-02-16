package me.yashims.korouter

class Matcher(routes: List<Route>) {

    private val tree: Route = Route("", "", object : Presenter {
        override fun onSwapInChild(name: String, child: Presenter, args: Map<String, String>) {}

        override fun onSwapOutChild(name: String, child: Presenter) {}
    })

    private val locationMatcher: Regex = Regex("^/?(:.+)")

    init {
        addChildren(tree, routes, enableReplace = true)
    }

    fun root(): Route = tree

    fun addChildren(parent: Route, children: List<Route>, enableReplace: Boolean = false) {
        if (parent.children == null || enableReplace) {
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
        addChildren(match(parentLocation), children)
    }

    fun match(location: String, route: Route = tree): Route {
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

        return route.children
            ?.firstOrNull {
                it.path == locationSlice || it.path.isBlank() || locationMatcher.matches(it.path)
            }
            ?.let {
                when {
                    it.path.isBlank() -> match(location, it)
                    nextLocation.isNotBlank() -> match(nextLocation, it)
                    else -> it
                }
            }
            ?: throw RouteNotMatchException()
    }
}