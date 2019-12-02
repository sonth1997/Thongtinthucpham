package com.wes.base.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.wes.base.activities.BaseAppActivity
import com.wes.base.activities.host.AppFragmentHost
import com.wes.base.api.Api
import com.wes.base.util.actionbar

/**
 * @author HungHN on 3/15/2019.
 * This is base App fragment.
 * It contains some default attributes:  Api, menu
 */
abstract class BaseAppFragment : WFragment() {

    var api: Api? = null

    private var mHandler: Handler? = null

    protected open val isHasActionbar: Boolean
        get() = true

    @get:LayoutRes
    abstract val layoutRes: Int

    protected open val progressView: View?
        get() = (activity as? BaseAppActivity)?.progressView

    init {
        arguments = Bundle()
    }

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppFragmentHost) {
            val fragmentHost = context as AppFragmentHost
            api = fragmentHost.api
        }
    }

    /**
     * Shouldn't override this function...Use [.getLayoutRes]
     */
    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        if (layoutRes != 0) {
            view = inflater.inflate(layoutRes, container, false)
        }
        return view
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (!isHasActionbar) {
            actionbar()?.hide()
        } else {
            actionbar()?.show()
        }
    }

    protected fun showLoading() {
        val loading = childFragmentManager.findFragmentByTag(LOADING_TAG)
        if (loading != null) return

        com.wes.base.dialog.LoadingDialogFragment().show(childFragmentManager, LOADING_TAG)
    }

    protected fun hideLoading() {

        if (mHandler == null) mHandler = Handler(Looper.getMainLooper())
        mHandler?.postDelayed(Runnable {
            val loading = childFragmentManager.findFragmentByTag(LOADING_TAG) ?: return@Runnable

            (loading as androidx.fragment.app.DialogFragment).dismissAllowingStateLoss()
        }, 500)
    }

    protected fun showDialog(dialog: androidx.fragment.app.DialogFragment?) {
        if (dialog == null) return

        dialog.show(childFragmentManager, DIALOG_TAG)
    }

    fun showProgressView() {
        if (progressView?.visibility != View.VISIBLE) {
            progressView?.visibility = View.VISIBLE
        }
    }

    fun hiddenProgressView() {
        if (progressView?.visibility == View.VISIBLE) {
            progressView?.visibility = View.GONE
        }
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()

        mHandler?.removeCallbacksAndMessages(null)
        mHandler = null
    }

    companion object {

        const val DIALOG_TAG = "dialog_tag"
        const val LOADING_TAG = "loading_tag"
    }
}
