package com.wes.app.ui.screens.settingprofile.done


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.wes.app.R
import com.wes.app.ui.screens.settingprofile.done.SettingProfile
import com.wes.app.ui.screens.settingprofile.done.SettingProfileAdapter
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_setting_frofiles.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SettingProflieFragment : BaseAppFragment(), SettingProfileAdapter.onClickItemSettingProfile {
    override val layoutRes = R.layout.fragment_setting_frofiles
     lateinit var adapterSettingProfile: SettingProfileAdapter
    private var mdata: MutableList<SettingProfile> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterSettingProfile = SettingProfileAdapter(this)
        adapterSettingProfile.setData(mdata)
        rcvSetting.adapter = adapterSettingProfile
        tvAdd.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSettingFroflie_to_blankFragment2)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    fun getListData(data: SettingProfile){
        mdata.add(data)
        adapterSettingProfile.setData(mdata)
    }

    override fun onClickItemSettingProfile(settingProfile: SettingProfile) {
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}

