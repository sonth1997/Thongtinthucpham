package com.wes.base.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.wes.app.R
import com.wes.base.activities.host.AppFragmentHost
import com.wes.base.api.Api
import com.wes.base.toolbox.AppActivityController

/**
 * @author HungHN on 3/15/2019.
 */

abstract class BaseAppActivity : WActivity(), AppFragmentHost {

    protected lateinit var mDelegate: AppActivityController

    override val api: Api
        get() = mDelegate.api


    open val progressView: View?
        get() = null

    open val onDestinationChangedListener: NavController.OnDestinationChangedListener?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mDelegate = AppActivityController(this)
        super.onCreate(savedInstanceState)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val isHandled = mDelegate.doDuringOnKeyDown(keyCode)

        return isHandled || super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        if (!mDelegate.doOnBackPress())
            super.onBackPressed()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        // Have the NavigationUI look for an action or destination matching the menu
        // item id and navigate there if found.
        // Otherwise, bubble up to the parent.
        return mDelegate.onOptionsItemSelected(item)
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        // Allows NavigationUI to support proper up navigation or the drawer layout
        // drawer menu, depending on the situation
        return mDelegate.onSupportNavigateUp()
    }
}
