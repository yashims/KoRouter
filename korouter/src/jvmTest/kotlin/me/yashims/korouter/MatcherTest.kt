package me.yashims.korouter

import junit.framework.Assert.assertEquals
import org.junit.Test

class MatcherTest {
    private val presenter: Presenter = object : Presenter {
        override fun onSwapInChild(name: String?, child: Presenter?, args: Map<String, String>?) {}
        override fun onSwapOutChild(name: String?, child: Presenter?) {}
    }

    private val children: List<Route> = listOf(
        Route("/", "index", presenter)
    )

    @Test
    fun `addChildren should be addition under specified node`() {
        val matcher = Matcher(emptyList())
        matcher.addChildren(matcher.root(), children)

        assertEquals(children[0], matcher.root().children!!.first())
    }

    @Test
    fun `addChildren should be addition under specified path node`() {
        val matcher = Matcher(
            listOf(Route("/", "index", presenter))
        )
        val children = listOf(Route("fiz", "fiz", presenter))
        matcher.addChildren("/", children)

        assertEquals(children[0], matcher.root().children!!.first().children!!.first())
    }
}