package com.wes.app.ui.screens.settingprofile.done

import com.wes.app.ui.screens.settingprofile.add.AddConfiguration

data class SettingProfile(
        val numberPeople: Int,
        val listFood: MutableList<AddConfiguration>
)