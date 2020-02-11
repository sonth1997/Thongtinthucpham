package com.wes.app.ui.activities

import android.os.Bundle
import com.wes.app.R
import com.wes.base.activities.BaseAppActivity

class FirstActivity : BaseAppActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        mDelegate.doOnInitNavigation()
    }
}