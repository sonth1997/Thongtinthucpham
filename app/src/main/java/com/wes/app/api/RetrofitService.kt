package com.wes.app.api

import com.wes.app.ui.screens.details.model.DishDetails
import com.wes.app.ui.screens.home.food.model.Suggestion
import com.wes.app.ui.screens.login.model.User
import com.wes.app.ui.screens.login.model.LoginRequest
import com.wes.base.api.ApiResponse
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.ArrayList

/**
 * @author HungHN on 3/15/2019.
 */

interface RetrofitService{
    @POST("/v1/app/auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<ApiResponse<User>>

    @GET ("/v1/client/user/mealSuggestions")
    fun mealSuggestions(): Call<ApiResponse<ArrayList<Suggestion>>>

    @GET("/v1/app/food/detail/{id}")
    fun mealDishDetails(@Path("id") id: String):Call<ApiResponse<DishDetails>>
}


