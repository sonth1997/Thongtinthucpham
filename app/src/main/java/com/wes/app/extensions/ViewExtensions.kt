package com.wes.app.extensions

import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wes.app.MyApp

/**
 * @author HungHN on 3/15/2019.
 */

val AppContext = MyApp.get()

fun ViewGroup.inflate(@LayoutRes resource: Int): View = LayoutInflater.from(context).inflate(resource, this, false)