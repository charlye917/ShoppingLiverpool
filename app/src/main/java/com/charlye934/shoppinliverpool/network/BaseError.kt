package com.charlye934.shoppinliverpool.network

import com.charlye934.shoppinliverpool.util.constants.ConstantsServices.GENERIC_CODE_ERROR

data class BaseError(
    val code: Int = GENERIC_CODE_ERROR,
    val message: String
)