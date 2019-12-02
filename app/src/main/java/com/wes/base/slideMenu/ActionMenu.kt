package com.wes.base.slideMenu

import com.wes.base.activities.WActivity

/**
 * @author HungHN on 3/15/2019.
 */

interface ActionMenu {

    val isShow: Boolean

    fun initialize(activity: WActivity)

    fun hide()

    fun show()

    fun destroy()
}
