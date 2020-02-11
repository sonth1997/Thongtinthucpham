package com.wes.app.ui.screens.home.food.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(@SerializedName("createdAt")
                 var createdAt : String,
                 @SerializedName("_id")
                 var _id : String,
                 @SerializedName("description")
                 var description : String,
                 @SerializedName("foodCategory")
                 var foodCategory : FoodCategory,
                 @SerializedName("name")
                 var name : String,
                 @SerializedName("image")
                 var image : String?,
                @SerializedName("foodId")
                var foodId : String,
                 @SerializedName("userId")
                 var userId : String): Parcelable