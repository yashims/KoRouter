package dev.yashims.routersample

import android.support.v4.app.FragmentManager
import dev.yashims.korouter.KoRouter
import java.lang.ref.WeakReference

object App {
    lateinit var router: KoRouter
    lateinit var fragmentManager: WeakReference<FragmentManager>
}
