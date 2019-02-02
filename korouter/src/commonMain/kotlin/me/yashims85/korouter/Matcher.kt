package me.yashims85.korouter

class Matcher(routes: List<Route>) {

    private val tree: Route = Route("", "", object : Presenter {})
    private val argPathRegex: Regex = Regex("^/?([^/]*)(.*)$")
    private val isParameterPath: Regex = Regex("^/?:")
    private val isMatchRoute: Regex = Regex("^/?:")

    init {
        addChildren(tree, routes)
    }

    private fun addChildren(parent: Route, children: List<Route>) {
        parent.children = children
        children.forEach {
            it.parent = parent
            it.children?.let { nextGenChildren ->
                addChildren(it, nextGenChildren)
            }
        }
    }

    fun match(location: String, route: Route = tree): List<Route> {
        val list: MutableList<Route> = mutableListOf()
        argPathRegex.matchEntire(location)?.apply {
            val (locationSlice, nextLocation) = this.groupValues

            // allow parameter path
            val isMatchPath = Regex("^/?(:|$locationSlice)")

            route.children?.forEach {
                if (isMatchPath.matches(it.path)) {
                    return list.apply {
                        add(it)
                        addAll(match(nextLocation, it))
                    }
                }
            }
        }
        return list
    }
}