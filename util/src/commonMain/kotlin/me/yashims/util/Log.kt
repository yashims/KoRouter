package me.yashims.util

internal enum class LogLevel {
    DEBUG, WARN, INFO, ERROR
}

internal expect fun logWrite(msg: String, logLevel: LogLevel)

object Log {
    fun d(msg: String) = logWrite(msg, LogLevel.DEBUG)
    fun d(exception: Exception) = d(exception.toString())
    fun w(msg: String) = logWrite(msg, LogLevel.WARN)
    fun w(exception: Exception) = w(exception.toString())
    fun e(msg: String) = logWrite(msg, LogLevel.ERROR)
    fun e(exception: Exception) = e(exception.toString())
}
