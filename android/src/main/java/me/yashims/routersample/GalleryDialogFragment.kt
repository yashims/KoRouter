package me.yashims.routersample

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import me.yashims.korouter.Presenter

class GalleryDialogFragment : DialogFragment(), Presenter {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(this.activity!!)
            .setTitle("選択")
            .setItems(arrayOf("aaa", "bbb", "ccc")) { dialog: DialogInterface?, which: Int ->
            }
            .create()
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        App.router.back()
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }

    override fun onSwapInChild(name: String, child: Presenter, args: Map<String, String>) {
        Log.d("korouter", "GalleryDialogFragment@onSwapInChild name: $name child:$child")
    }

    override fun onSwapOutChild(name: String, child: Presenter) {
        Log.d("korouter", "GalleryDialogFragment@onSwapOutChild name: $name child:$child")
    }
}
