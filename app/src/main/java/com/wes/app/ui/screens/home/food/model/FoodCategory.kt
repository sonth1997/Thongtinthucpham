package com.wes.app.ui.screens.home.food.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodCategory (
                    @SerializedName("isShow")
                    var isShow : Boolean?,
                    @SerializedName("isUserConfig")
                    var isUserConfig : Boolean?,
                    @SerializedName("level")
                    var level : Int?,
                    @SerializedName("_id")
                    var _id : String,
                    @SerializedName("name")
                    var name : String?,
                    @SerializedName("urlName")
                    var urlName : String?): Parcelable // truyen dữ liệu