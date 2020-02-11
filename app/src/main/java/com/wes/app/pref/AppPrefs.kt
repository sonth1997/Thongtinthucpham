package com.wes.app.pref

import android.content.SharedPreferences
import com.wes.app.extensions.AppContext
import com.wes.app.ui.screens.login.model.User
import com.wes.base.prefers.PreferenceHelper
import com.wes.base.prefers.get
import com.wes.base.prefers.set

/**
 * @author by hunghoang on 7/21/18.
 */
class AppPrefs {
    private val pref: SharedPreferences

    init {
        pref = PreferenceHelper.newPrefs(AppContext, SHARE_PREF_NAME)
    }

    companion object {
        private const val SHARE_PREF_NAME = "App.Pref"
        private const val SHARE_PREF_USER = "App.Pref.user"
        @Volatile
        private var INSTANCE: AppPrefs? = null

        fun getInstance() =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: AppPrefs().also {
                        INSTANCE = it
                    }
                }
    }

    var user: User?
        get() = pref[SHARE_PREF_USER]
        set(value) {
            if (value != null) {
                pref[SHARE_PREF_USER] = value
            } else {
                pref.edit().remove(SHARE_PREF_USER).apply()
            }
        }
}