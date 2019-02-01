package me.yashims85.korouter

class History() {

    private var currentRoute: Route = Route(
        path = "",
        name = "",
        component = object : Presenter {},
        children = emptyList()
    )

    private val history: MutableList<String> = mutableListOf()

    fun push(location: String) {

    }
}