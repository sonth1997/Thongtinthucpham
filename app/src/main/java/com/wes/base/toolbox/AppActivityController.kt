package com.wes.base.toolbox

import android.view.KeyEvent
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.wes.app.MyApp
import com.wes.app.R
import com.wes.base.activities.BaseAppActivity
import com.wes.base.activities.host.AppFragmentHost
import com.wes.base.api.Api
import com.wes.base.util.goBack


/**
 * @author HungHN on 3/15/2019.
 */
class AppActivityController(private val activity: BaseAppActivity) : AppFragmentHost {


    private val mApi = MyApp.get().api

    private var appBarConfiguration: AppBarConfiguration? = null

    override val api: Api
        get() = mApi

    fun doOnInitNavigation(): NavController? {
        val host: NavHostFragment = activity.supportFragmentManager
                .findFragmentById(R.id.fragmentHolder) as NavHostFragment? ?: return null

        // Set up Action Bar
        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        // You should also remove the old appBarConfiguration setup above
        appBarConfiguration = activity.findViewById<DrawerLayout>(R.id.drawerLayout)?.let { drawerLayout ->
            AppBarConfiguration(
                    setOf(R.id.nav_today, R.id.nav_favorite, R.id.nav_food, R.id.nav_profile),
                    drawerLayout)


        }
        activity.actionBar?.let {
            setupActionBar(navController, appBarConfiguration)
        }

        setupNavigationMenu(navController)
        setupBottomNavMenu(navController)
        activity.onDestinationChangedListener?.let { navController.addOnDestinationChangedListener(it) }
        return navController
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNav?.setupWithNavController(navController)
    }

    private fun setupNavigationMenu(navController: NavController) {
        // In split screen mode, you can drag this view out from the left
        // This does NOT modify the actionbar
        val sideNavView = activity.findViewById<NavigationView>(R.id.navigationView)
        sideNavView?.setupWithNavController(navController)
    }

    private fun setupActionBar(navController: NavController,
                               appBarConfig: AppBarConfiguration?) {
        appBarConfig?.let {
            activity.setupActionBarWithNavController(navController, it)
        }
    }



    /**
     * @return true if handled, else return false
     */
    fun doDuringOnKeyDown(keyCode: Int): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            callBackHandlerOnActivePage()
        } else false

    }

    fun doOnBackPress(): Boolean {
        return callBackHandlerOnActivePage()
    }

    private fun callBackHandlerOnActivePage(): Boolean {
        return activity.goBack()
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(activity.findNavController(R.id.fragmentHolder))
    }

    fun onSupportNavigateUp(): Boolean {
        return appBarConfiguration?.let { activity.findNavController(R.id.fragmentHolder).navigateUp(it) } ?: false
    }
}
