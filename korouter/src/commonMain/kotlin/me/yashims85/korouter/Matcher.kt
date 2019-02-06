package me.yashims85.korouter

class Matcher(routes: List<Route>) {

    private val tree: Route = Route("", "", object : Presenter {
        override fun onSwapInChild(name: String, child: Presenter, args: Map<String, String>) {}

        override fun onSwapOutChild(name: String, child: Presenter) {}
    })

    private val locationMatcher: Regex = Regex("^/?(:.+)")

    init {
        addChildren(tree, routes)
    }

    fun root(): Route = tree
    fun addChildren(parent: Route, children: List<Route>) {
        parent.children = children
        children.forEach {
            it.parent = parent
            it.children?.let { nextGenChildren ->
                addChildren(it, nextGenChildren)
            }
        }
    }

    fun addChildren(parentLocation: String, children: List<Route>) {
        addChildren(match(parentLocation), children)
    }

    fun match(location: String, route: Route = tree): Route {
        var (locationSlice, nextLocation) = location.split('/', limit = 2)

        // if current location is blank avoid current location slice.
        if (locationSlice.isBlank() && nextLocation.isNotBlank()) {
            return match(nextLocation, route)
        }

        if (locationSlice.isBlank()) {
            locationSlice = "/"
        }

        return route.children
            ?.firstOrNull {
                it.path == locationSlice || locationMatcher.matches(locationSlice)
            }
            ?.let {
                if (nextLocation.isBlank()) {
                    it
                } else {
                    match(nextLocation, it)
                }
            }
            ?: throw RouteNotMatchException()
    }

    class RouteNotMatchException : Exception()

//    private val argPathRegex: Regex = Regex("^/?([^/]*)(.*)$")
//    fun match3(location: String, route: Route = tree): List<Route> {
//        val list: MutableList<Route> = mutableListOf()
//        argPathRegex.matchEntire(location)?.apply {
//            val (locationSlice, nextLocation) = this.groupValues
//
//            // allow parameter path
//            val isMatchPath = Regex("^/?(:.+|$locationSlice)")
//
//            route.children?.forEach {
//                if (isMatchPath.matches(it.path)) {
//                    return list.apply {
//                        add(it)
//                        addAll(match(nextLocation, it))
//                    }
//                }
//            }
//        }
//        return list
//    }
}