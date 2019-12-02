package com.wes.app.pref

import android.content.SharedPreferences
import com.wes.app.extensions.AppContext
import com.wes.base.prefers.PreferenceHelper

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

        @Volatile
        private var INSTANCE: AppPrefs? = null

        fun getInstance() =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: AppPrefs().also {
                        INSTANCE = it
                    }
                }
    }
}