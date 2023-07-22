package com.yin.sms.common.response

enum class ApiStatus(val code: String, val msg: String) {
    E0000("0000", "success"),
    E1000("1000", "No suitable data"),
    E2000("2000", "External api communication error"),
    E9999("9999", "An unknown error has occurred");
}