package com.wes.app.ui.screens.details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutritionalValue(@SerializedName("_id")
                            var _id : String?,
                            @SerializedName("nutritionId")
                            var nutritionId :  String?,
                            @SerializedName("value")
                            var value : String?): Parcelable