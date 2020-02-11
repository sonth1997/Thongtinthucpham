package com.wes.app.ui.screens.home.food.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Favorite (@SerializedName("_id")
                     var _id : String,
                     @SerializedName("value")
                     var food : Food?,
                     @SerializedName("order")
                     var order : Int?,
                     @SerializedName("meal")
                     var meal : String?): Parcelable

