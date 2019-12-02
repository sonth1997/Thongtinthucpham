package com.wes.app.api.errors

import com.wes.base.api.errors.BaseError

/**
 * @author HungHN on 3/15/2019.
 */
data class ParserError(override val requestId: String,
                       override val response: String = "Parser error") : BaseError(requestId, response)
