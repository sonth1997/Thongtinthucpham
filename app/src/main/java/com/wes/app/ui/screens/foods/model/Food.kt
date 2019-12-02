package com.wes.app.ui.screens.foods.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Food (val menuFood : String, val  food: String, val imageFood : Int) : Parcelable