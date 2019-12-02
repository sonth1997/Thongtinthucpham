package com.wes.app.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import com.wes.app.R
import com.wes.base.activities.BaseAppActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @author HungHN on 3/15/2019.
 */

class MainActivity : BaseAppActivity() {
    override val progressView: View?
        get() = fProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Toolbar>(R.id.toolbar)?.let {
            toolbar
            setSupportActionBar(toolbar)
        }

        supportActionBar?.apply {
            setDisplayShowCustomEnabled(false)
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        }

        mDelegate.doOnInitNavigation()
    }
    
    private val m0nDestinationChanged = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when (destination.id) {
            R.id.detailsFragment -> {
                bottomNavView?.visibility = View.GONE
            }
            else -> {
                bottomNavView?.visibility = View.VISIBLE
            }
        }
    }

    override val onDestinationChangedListener: NavController.OnDestinationChangedListener?
        get() = m0nDestinationChanged
}
