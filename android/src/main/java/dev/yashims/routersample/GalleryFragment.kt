package dev.yashims.routersample

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.yashims.korouter.Presenter
import dev.yashims.routersample.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class GalleryFragment : Fragment(), Presenter {

    // TODO: Customize parameters
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gallery_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = GalleryRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }

    override fun onSwapInChild(name: String?, child: Presenter?, args: Map<String, String>?) {
        Log.d("korouter", "GalleryFragment@onSwapInChild name: $name child:$child args:$args")
        if (child is DialogFragment) {
            App.fragmentManager.get()?.apply {
                child.show(this, "Please Select")
            }
        }
    }

    override fun onSwapOutChild(name: String?, child: Presenter?) {
        Log.d("korouter", "GalleryFragment@onSwapOutChild name:$name, child:$child")
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            GalleryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
