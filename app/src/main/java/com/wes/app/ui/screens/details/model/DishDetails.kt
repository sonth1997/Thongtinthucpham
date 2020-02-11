package com.wes.app.ui.screens.details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DishDetails (@SerializedName("objects")
                        var objc : ArrayList<Objc>?,
                        @SerializedName("currentPage")
                        var currentPage :   String?,
                        @SerializedName("pages")
                        var pages : String?,
                        @SerializedName("total")
                        var total : String?): Parcelable
