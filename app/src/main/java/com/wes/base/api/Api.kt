package com.wes.base.api

import com.wes.app.ui.screens.details.model.DishDetails
import com.wes.app.ui.screens.home.food.model.Suggestion
import com.wes.app.ui.screens.login.model.User
import com.wes.app.ui.screens.login.model.LoginRequest
import com.wes.base.api.errors.BaseError


/**
 * @author HungHN on 3/15/2019.
 * define fun request api
 */

internal typealias ApiError = (requestId: String, e: BaseError) -> Unit

internal typealias ApiSuccess<T> = (requestId: String, T) -> Unit

interface Api {
    fun login(request: String, loginRequest: LoginRequest, success: ApiSuccess<ApiResponse<User>>, error: ApiError)

    // man hinh home
    fun mealSuggestions(request: String, error: ApiError, success: ApiSuccess<ApiResponse<ArrayList<Suggestion>>>)

    // man hinh detail
    fun mealDishDetails(request: String, id: String, error: ApiError, success: ApiSuccess<ApiResponse<DishDetails>>)
}

