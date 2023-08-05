package com.yin.sms.common.response

class ApiResponse<T>(
        val data: T,
        val statusCode: String = ApiStatus.E0000.code,
        val statusMsg: String = ApiStatus.E0000.msg
)
