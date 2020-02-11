package com.wes.app.ui.screens.login.model

import com.google.gson.annotations.SerializedName

/**
 * Created by HungHN on 3/16/18.
 */
data class User(
        @SerializedName("_id")
        var _id: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("newAccount")
        val newAccount: Boolean,
        @SerializedName("token")
        val token: String)