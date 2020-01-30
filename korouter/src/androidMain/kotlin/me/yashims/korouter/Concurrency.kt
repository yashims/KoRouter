package me.yashims.korouter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

actual fun <T> korouterRunBlocking(context: CoroutineContext, block: suspend CoroutineScope.() -> T): T =
    runBlocking(context, block)
