package me.yashims.korouter

import kotlin.test.BeforeTest

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

    @BeforeTest
    fun beforeEach() {
        matchedNodeNames = mutableListOf()
        givenArgs = null
        router = KoRouter {
            route("/") {
                name = "index"
                component = presenter

                children {
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

                    route("/news") {
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

//    @Test
//    fun `Matched terminate node should be given null name`() {
//        router.push("/news")
//        assertNull(matchedNodeNames.last())
//    }
//
//    @Test
//    fun `Matched upper terminate node should be given child name`() {
//        router.push("/campaign/0001")
//        assertEquals(matchedNodeNames.last { it != null }, "campaign0001")
//    }
}