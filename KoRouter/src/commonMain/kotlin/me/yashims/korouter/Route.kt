package me.yashims.korouter

data class Route(
    val path: String,
    val name: String,
    val component: Presenter,
    var children: MutableList<Route>? = null,
    var parent: Route? = null
) {
    fun fullPath(): String {
        return parent?.let {
            val fullPath = it.fullPath()
            if (fullPath.isBlank()) path else "$fullPath/$path"
        } ?: path
    }

    fun fullNodes(): MutableList<Route> {
        return parent?.let {
            it.fullNodes().apply {
                add(this@Route)
            }
        } ?: mutableListOf(this)
    }

    override fun toString(): String {
        return path
    }
}
