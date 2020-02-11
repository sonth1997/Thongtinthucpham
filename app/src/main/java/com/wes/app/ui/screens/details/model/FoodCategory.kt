package com.wes.app.ui.screens.details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodCategory (@SerializedName("isShow")
                        var isShow : Boolean?,
                        @SerializedName("_id")
                        var _id :  String?,
                        @SerializedName("name")
                        var name : String?,
                        @SerializedName("urlName")
                        var urlName : String?,
                        @SerializedName("__v")
                        var __v :  String?):Parcelable