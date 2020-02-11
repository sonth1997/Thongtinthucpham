package com.wes.app.ui.screens.details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ingredient (@SerializedName("ingredient")
                        var ingredient :  String?,
                        @SerializedName("value")
                        var value : String?,
                        @SerializedName("unit")
                        var unit : String?): Parcelable