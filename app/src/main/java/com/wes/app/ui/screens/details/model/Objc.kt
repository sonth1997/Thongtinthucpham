package com.wes.app.ui.screens.details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Objc  (@SerializedName("tags")
             var tags : ArrayList<Tags>?,
                  @SerializedName("ingredient")
             var ingredient :  ArrayList<Ingredient>?,
                  @SerializedName("name")
             var name : String?,
                  @SerializedName("urlName")
                   var urlName : String?,
                  @SerializedName("foodCategory")
            var foodCategory :  ArrayList<FoodCategory>?,
                  @SerializedName("description")
            var description : String?,
                  @SerializedName("content")
            var content : String?,
                  @SerializedName("image")
            var image : String?,
                  @SerializedName("nutritionalValue")
            var nutritionalValue :  ArrayList<NutritionalValue>?,
                  @SerializedName("dosageVolume")
            var dosageVolumn : String?,
                  @SerializedName("createdAt")
            var createdAt : String?): Parcelable
