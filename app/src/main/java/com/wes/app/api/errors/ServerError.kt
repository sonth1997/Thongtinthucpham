package com.wes.app.api.errors

import com.wes.base.api.errors.BaseError

/**
 * @author HungHN on 3/15/2019.
 */
data class ServerError(override val requestId: String,
                       override val response: String = "Server error") : BaseError(requestId, response)
