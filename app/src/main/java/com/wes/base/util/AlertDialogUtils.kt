package com.wes.base.util

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

/**
 * @author by hunghoang on 2019-05-16.
 */
object AlertDialogUtils {

    fun showAlertOneButton(context: Context, title: String? = null, message: String? = null, action: DialogInterface.OnClickListener): AlertDialog {
        val builder = AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("OK", action)
        return builder.show()
    }

    fun showAlertOneButton(context: Context, title: Int? = null, message: Int? = null, action: DialogInterface.OnClickListener): AlertDialog {
        val builder = AlertDialog.Builder(context);
        title?.let { builder.setTitle(it) }
        message?.let { builder.setMessage(it) }
        builder.setNegativeButton("OK", action)
        return builder.show()
    }
}