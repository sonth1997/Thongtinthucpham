package com.wes.app.ui.screens.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.wes.app.R
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_profile.*




class ProfileFragment: BaseAppFragment() {
    override val layoutRes = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reSetting.setOnClickListener {
            findNavController().navigate(R.id.action_nav_profile_to_fragmentSettingFroflie)
        }
        reFavorite.setOnClickListener {
            findNavController().navigate(R.id.action_nav_profile_to_nav_favorite)
        }
    }
}