package me.yashims85.korouter

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

// TODO to trash
val myRoutes: List<Route> = listOf(
    Route("/", "index", object : Presenter {}).apply {
        children = listOf(
            Route("debug", "index", object : Presenter {})
        )
    }
)

class KoRouter(private val routes: List<Route>) {

    private val matcher: Matcher = Matcher(routes)

    fun push(location: String) = GlobalScope.async {
    }
}
