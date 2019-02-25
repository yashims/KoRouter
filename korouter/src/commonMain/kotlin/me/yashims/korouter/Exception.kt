package me.yashims.korouter

class RouteNotMatchException(override val message: String) : Exception()

class OutOfHistoryRangeException : Exception()
