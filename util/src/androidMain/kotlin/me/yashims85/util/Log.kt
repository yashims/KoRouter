package me.yashims85.util

private const val APP_TAG: String = "me.yashims85.util"

internal actual fun logWrite(msg: String, logLevel: LogLevel) {
    when (logLevel) {
        LogLevel.DEBUG -> {
            android.util.Log.d(APP_TAG, msg)
        }
        LogLevel.WARN -> {
            android.util.Log.w(APP_TAG, msg)
        }
        LogLevel.ERROR -> {
            android.util.Log.e(APP_TAG, msg)
        }
    }
}
