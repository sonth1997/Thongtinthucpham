package com.wes.base.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.wes.base.dialog.listener.OnActionInDialogListener
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author HungHN on 3/15/2019.
 */
abstract class WFragment : Fragment(), OnActionInDialogListener, OnFragmentResultListener {

    private var mSaveInstanceStateCalled: Boolean = false
    private var disposableOnPaused: CompositeDisposable = CompositeDisposable()
    private var disposableOnDestroyed: CompositeDisposable = CompositeDisposable()
    private var disposableOnViewDestroyed: CompositeDisposable = CompositeDisposable()
    private var disposableMap = mutableMapOf<String, Disposable>()

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mSaveInstanceStateCalled = false
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSaveInstanceStateCalled = false
    }

    /**
     * Shouldn't override this function...Use [.getLayoutRes]
     */
    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mSaveInstanceStateCalled = false
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (disposableOnViewDestroyed.isDisposed) disposableOnViewDestroyed = CompositeDisposable()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        mSaveInstanceStateCalled = false
        if (disposableOnPaused.isDisposed) disposableOnPaused = CompositeDisposable()
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        mSaveInstanceStateCalled = false
    }

    override fun onPause() {
        super.onPause()
        disposableOnPaused.dispose()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposableOnViewDestroyed.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposableOnDestroyed.dispose()
    }


    protected fun Disposable.disposeOnPaused(tag: String? = null) = apply {
        tag?.let { disposableMap.put(it, this) }?.dispose()
        disposableOnPaused.add(this)
    }

    protected fun Disposable.disposeOnDestroyed(tag: String? = null) = apply {
        tag?.let { disposableMap.put(it, this) }?.dispose()
        disposableOnDestroyed.add(this)
    }

    protected fun Disposable.disposeOnViewDestroyed(tag: String? = null) = apply {
        tag?.let { disposableMap.put(it, this) }?.dispose()
        disposableOnViewDestroyed.add(this)
    }

    protected fun disposeTag(tag: String) = disposableMap[tag]?.dispose()

    /**
     * Method check state of fragment. Can not change state of fragment (like:
     * navigate in fragment, change layout...)
     *
     * @return true Valid for change state, otherwise not valid
     */
    fun canChangeFragmentManagerState(): Boolean {
        val activity = activity
        return !(mSaveInstanceStateCalled || activity == null || activity.isFinishing)
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mSaveInstanceStateCalled = true
    }

    /**
     * Implement the default action listener from dialog result
     */
    override fun onDialogResult(requestCode: Int, action: Int, extraData: Intent?) {

    }

    /**
     * Implement the default action listener from target fragment
     */
    override fun onFragmentResult(requestCode: Int, action: Int, extraData: Intent?) {
    }
}
