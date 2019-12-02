package com.wes.base.api


/**
 * @author HungHN on 3/15/2019.
 * define fun request api
 */

internal typealias ApiError = (requestId: String, e: com.wes.base.api.errors.BaseError) -> Unit

internal typealias ApiSuccess<T> = (requestId: String, T) -> Unit

interface Api
