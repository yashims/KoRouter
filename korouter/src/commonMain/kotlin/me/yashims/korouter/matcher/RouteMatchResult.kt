package me.yashims.korouter.matcher

import me.yashims.korouter.Route

data class RouteMatchResult(
    val route: Route,
    val param: Map<String, String>? = null
) {
    fun copy(param: Map<String, String>? = null): RouteMatchResult {
        return RouteMatchResult(
            route,
            param?.let { this.param?.plus(it) ?: it } ?: this.param
        )
    }
}