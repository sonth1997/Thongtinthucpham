package com.wes.app.ui.screens.details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tags (
    @SerializedName("name")
    var name : String?): Parcelable
