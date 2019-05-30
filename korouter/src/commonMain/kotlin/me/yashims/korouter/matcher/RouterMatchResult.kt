package me.yashims.korouter.matcher

import me.yashims.korouter.Route

data class RouterMatchResult(
    val route: Route,
    val param: Map<String, String>? = null
) {
    fun copy(param: Map<String, String>? = null): RouterMatchResult {
        return RouterMatchResult(
            route,
            param?.let { this.param?.plus(it) ?: it } ?: this.param
        )
    }
}