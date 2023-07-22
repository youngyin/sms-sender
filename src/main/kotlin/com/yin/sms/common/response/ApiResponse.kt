package com.yin.sms.common.response

class ApiResponse<T>(
        var data: T,
        status: ApiStatus = ApiStatus.E0000
){
    val statusCode = status.code
    val statusMsg = status.msg
}
