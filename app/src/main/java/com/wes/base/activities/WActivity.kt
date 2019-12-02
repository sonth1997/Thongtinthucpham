package com.wes.base.activities

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author HungHN on 3/15/2019.
 * This is base mActivity for WES
 */
abstract class WActivity : AppCompatActivity() {

    private var mSaveInstanceStateCalled: Boolean = false
    private var disposableOnPaused = CompositeDisposable()
    private val disposableOnDestroyed = CompositeDisposable()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSaveInstanceStateCalled = false
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        mSaveInstanceStateCalled = false
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        mSaveInstanceStateCalled = false
        if (disposableOnPaused.isDisposed) disposableOnPaused = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        disposableOnPaused.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposableOnDestroyed.dispose()
    }

    protected fun Disposable.disposeOnPaused() = apply { disposableOnPaused.add(this) }

    protected fun Disposable.disposeOnDestroyed() = apply { disposableOnDestroyed.add(this) }


    fun canChangeFragmentManagerState(): Boolean {
        return !(mSaveInstanceStateCalled || isFinishing)
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mSaveInstanceStateCalled = true
    }

    companion object {
        protected val TAG = "WESActivity"
    }
}
