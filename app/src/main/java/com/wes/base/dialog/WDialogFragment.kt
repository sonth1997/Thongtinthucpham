package com.wes.base.dialog

import android.content.DialogInterface
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.DialogFragment
import com.wes.base.dialog.toolbox.NotifyUtil

/**
 * @author HungHN on 3/15/2019.
 */
abstract class WDialogFragment : DialogFragment() {

    protected var mRequestCode: Int = 0

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            getDataFrom(savedInstanceState)
        } else {
            val bundle = arguments
            if (bundle != null)
                getDataFrom(bundle)
        }
    }

    @CallSuper
    protected open fun getDataFrom(bundle: Bundle) {
        mRequestCode = bundle.getInt(EXTRA_REQUEST_CODE)
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_REQUEST_CODE, mRequestCode)
    }

    @CallSuper
    override fun onCancel(dialog: DialogInterface) {
        NotifyUtil.notifyAction(false, this, null, mRequestCode, ACTION_CANCEL)
    }

    companion object {

        const val ACTION_CANCEL = -1
        private const val EXTRA_REQUEST_CODE = "extra_request_code"

        fun makeBundle(requestCode: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(EXTRA_REQUEST_CODE, requestCode)
            return bundle
        }
    }
}
