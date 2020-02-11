package com.wes.app.api

import com.wes.app.BuildConfig
import com.wes.app.Config
import com.wes.app.pref.AppPrefs
import com.wes.app.ui.screens.details.model.DishDetails
import com.wes.app.ui.screens.home.food.model.Suggestion
import com.wes.app.ui.screens.login.model.User
import com.wes.app.ui.screens.login.model.LoginRequest
import com.wes.base.api.Api
import com.wes.base.api.ApiError
import com.wes.base.api.ApiResponse
import com.wes.base.api.ApiSuccess
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author HungHN on 3/15/2019.
 */

class RetrofitApi : Api {

    private var retrofitService: RetrofitService

    init {
        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor())
                .addInterceptor { chain ->
                    val ongoing = chain.request().newBuilder()
                    ongoing.header("Content-Type", "application/json")
                    val token = AppPrefs.getInstance().user?.token
                    if (!token.isNullOrEmpty()) {
                        ongoing.addHeader("Authorization", "Bearer ${token}")
                    }
                    chain.proceed(ongoing.build())
                }
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        retrofitService = retrofit.create(RetrofitService::class.java)
    }

    private fun httpLoggingInterceptor(): Interceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }


    override fun login(request: String, loginRequest: LoginRequest, success: ApiSuccess<ApiResponse<User>>, error: ApiError) {
        val call = retrofitService.login(loginRequest)
        call.enqueue(RetrofitCallback<ApiResponse<User>> (request, error, success))
    }
    // man hinh home
    override fun mealSuggestions(request: String, error: ApiError, success: ApiSuccess<ApiResponse<ArrayList<Suggestion>>>) {
        val call = retrofitService.mealSuggestions()
        call.enqueue(RetrofitCallback<ApiResponse<ArrayList<Suggestion>>>(request, error,success))
    }



    // man hinh detail
    override fun mealDishDetails(request: String,id: String, error: ApiError, success: ApiSuccess<ApiResponse<DishDetails>>) {
        val call = retrofitService.mealDishDetails(id)
        call.enqueue(RetrofitCallback<ApiResponse<DishDetails>>(request,error,success))
    }
}
