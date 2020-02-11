package com.wes.base.api

import com.google.gson.annotations.SerializedName

/**
 * @author HungHN on 3/15/2019.
 */

data class ApiResponse<T>(@SerializedName("code")
                          var code: Int,
                          @SerializedName("status")
                          var status: Boolean,
                          @SerializedName("message")
                          var message: String?,
                          @SerializedName("data")
                          var data: T?) {

    val isSuccess: Boolean
        get() = (code == 200)
}
