package me.yashims.util

import platform.Foundation.NSLog

private const val APP_TAG: String = "me.yashims"
internal actual fun logWrite(msg: String, logLevel: LogLevel) {
    when (logLevel) {
        LogLevel.DEBUG -> {
            NSLog("D/%s: %s", APP_TAG, msg)
        }
        LogLevel.INFO -> {
            NSLog("I/%s: %s", APP_TAG, msg)
        }
        LogLevel.WARN -> {
            NSLog("W/%s: %s", APP_TAG, msg)
        }
        LogLevel.ERROR -> {
            NSLog("E/%s: %s", APP_TAG, msg)
        }
    }
}
