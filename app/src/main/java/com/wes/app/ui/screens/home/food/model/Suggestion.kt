package com.wes.app.ui.screens.home.food.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Suggestion (
        @SerializedName("_id")
        var _id : String,
        @SerializedName("day")
        var day : String?,
        @SerializedName("meal")
        var meal : String?,
        @SerializedName("favorite")
        var favorite : ArrayList<Favorite>,
        @SerializedName("user")
        var user : String?,
        @SerializedName("createdAt")
        var createdAt : String?) : Parcelable