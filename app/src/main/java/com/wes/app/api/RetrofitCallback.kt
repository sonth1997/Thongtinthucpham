package com.wes.app.api

import com.wes.base.api.ApiError
import com.wes.base.api.ApiSuccess
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by HungHN on 3/16/18.
 */
class RetrofitCallback<T>(private val requestId: String,
                          private val apiError: ApiError,
                          private val apiSuccess: ApiSuccess<T>) : Callback<T> {

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        apiError.invoke(requestId, com.wes.app.api.errors.ServerError(requestId, t.toString()))
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        response?.body()?.let {
            apiSuccess.invoke(requestId, it)
            return
        }

        apiError.invoke(requestId, com.wes.app.api.errors.ParserError(requestId))
    }
}