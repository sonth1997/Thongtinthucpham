package com.wes.app.ui.screens

import android.os.Bundle
import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.wes.app.R
import com.wes.base.fragments.BaseAppFragment

class SplashFragment: BaseAppFragment() {

    private val handler = Handler()

    override val layoutRes: Int = R.layout.fragment_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handler.postDelayed({
            findNavController().navigate(R.id.action_splash_to_login)
        }, 1000L)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
    }
}