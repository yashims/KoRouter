package me.yashims.korouter

import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class KoRouterTest {
    private lateinit var router: KoRouter
    private var matchedNodeNames: MutableList<String?> = mutableListOf()
    private var givenArgs: Map<String, String>? = null
    private val presenter = object : Presenter {
        override fun onSwapInChild(name: String?, child: Presenter?, args: Map<String, String>?) {
            matchedNodeNames.add(name)
            givenArgs = args
        }

        override fun onSwapOutChild(name: String?, child: Presenter?) {}
    }

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
//    private val mainThreadSurrogate = Dispatchers.Main

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)

        matchedNodeNames = mutableListOf()
        givenArgs = null
        router = KoRouter {
            route("") {
                name = ""
                component = presenter

                children {

                    route("/") {
                        name = "index"
                        component = presenter
                    }

                    route("users") {
                        name = path
                        component = presenter

                        children {
                            route(":detail") {
                                name = "userDetail"
                                component = presenter

                                children {
                                    route("friends") {
                                        name = "userFriends"
                                        component = presenter

                                        children {
                                            route(":detail") {
                                                name = "userFriendsDetail"
                                                component = presenter
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } // route of users

                    route("news") {
                        name = "news"
                        component = presenter

                        children {
                            route("nwsHeadlines") {
                                name = "newsHeadlines"
                                component = presenter
                            }

                            route(":detail") {
                                name = "newsDetail"
                                component = presenter
                            }
                        }
                    } // route of news

                    route("campaign") {
                        name = "campaign"
                        component = presenter

                        children {
                            route("summary") {
                                name = "campaignSummary"
                                component = presenter
                            }
                            route("") {
                                name = "campaignNav"
                                component = presenter

                                children {
                                    route("0001") {
                                        name = "campaign0001"
                                        component = presenter
                                    }
                                    route("0002") {
                                        name = "campaign0002"
                                        component = presenter
                                    }
                                }
                            }
                        }
                    } // route of campaign
                }
            }
        } // end of KoRouter

    }

    @Test
    fun `Matched terminate node should be given null name`() = runBlockingTest {
        router.push("news")
        delay(50L)
        assertTrue(matchedNodeNames.size > 0)
        assertNull(matchedNodeNames.lastOrNull())
    }

    @Test
    fun `Matched upper terminate node should be given child name`() = runBlockingTest {
        router.push("/campaign/0001")
        delay(50L)
        assertEquals(matchedNodeNames.last { it != null }, "campaign0001")
    }
}