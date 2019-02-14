package me.yashims85.routersample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yashims85.korouter.Presenter

class TopFragment : Fragment(), Presenter {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onSwapInChild(name: String, child: Presenter, args: Map<String, String>) {
        Log.d("korouter", "TopFragment@onSwapInChild name: $name")
        if (child is Fragment) {
            Log.d("korouter", "TopFragment@onSwapInChild child:$child")
            App.fragmentManager.get()?.beginTransaction()?.apply {
                replace(R.id.content_main, child)
                commit()
            }
        }
    }

    override fun onSwapOutChild(name: String, child: Presenter) {
        Log.d("korouter", "TopFragment@onSwapOutChild name:$name, child:$child")
    }
}