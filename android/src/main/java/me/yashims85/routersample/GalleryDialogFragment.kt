package me.yashims85.routersample

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import me.yashims85.korouter.Presenter

class GalleryDialogFragment : DialogFragment(), Presenter {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(this.activity!!)
            .setTitle("選択")
            .setItems(arrayOf("aaa", "bbb", "ccc")) { dialog: DialogInterface?, which: Int ->
                App.router.back()
            }
            .create()
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }

    override fun onSwapInChild(name: String, child: Presenter, args: Map<String, String>) {
    }

    override fun onSwapOutChild(name: String, child: Presenter) {
    }
}
