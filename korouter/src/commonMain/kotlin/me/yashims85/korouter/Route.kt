package me.yashims85.korouter

data class Route(
    val path: String,
    val name: String?,
    val component: Presenter,
    val children: List<Route>
)