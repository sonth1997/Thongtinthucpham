package com.wes.base.dialog.toolbox

import android.content.Intent
import com.wes.base.dialog.WDialogFragment
import com.wes.base.dialog.listener.OnActionInDialogListener
import com.wes.base.fragments.OnFragmentResultListener

/**
 * @author HungHN on 3/15/2019.
 * This class is used to notify events from
 *
 * DialogFragment -> Fragment host
 * Fragment -> target Fragment
 */
object NotifyUtil {

    fun notifyAction(isDismiss: Boolean, dialog: WDialogFragment?, intent: Intent?, requestCode: Int, action: Int) {
        if (dialog == null) {
            throw IllegalStateException("Dialog cannot be null !")
        }

        if (isDismiss) dialog.dismiss()

        val responseFragment = dialog.parentFragment
        if (responseFragment != null && responseFragment is OnActionInDialogListener) {
            (responseFragment as OnActionInDialogListener).onDialogResult(requestCode, action, intent)
            return
        }

        val activity = dialog.activity
        if (activity != null && activity is OnActionInDialogListener) {
            (activity as OnActionInDialogListener).onDialogResult(requestCode, action, intent)
        }
    }

    fun notifyFragmentAction(fragment: androidx.fragment.app.Fragment?, action: Int, intent: Intent?) {
        if (fragment == null) return

        val sourceFragment = fragment.targetFragment
        if (sourceFragment == null || sourceFragment !is OnFragmentResultListener) return

        (sourceFragment as OnFragmentResultListener).onFragmentResult(fragment.targetRequestCode, action, intent)
    }
}
