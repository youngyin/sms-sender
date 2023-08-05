package com.yin.sms.common.exception

import com.yin.sms.common.response.ApiResponse
import com.yin.sms.common.response.ApiStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e : MethodArgumentNotValidException) : ResponseEntity<ApiResponse<*>> {
        val errMsg = e.bindingResult.allErrors.map { it.defaultMessage }.joinToString(", ")
        return ResponseEntity.ok(ApiResponse(
                        statusCode = ApiStatus.E9000.code,
                        statusMsg = "${ApiStatus.E9000.msg}(${errMsg})",
                        data = null
        ))
    }

    @ExceptionHandler(Exception::class)
    fun defaultException(e : Exception) : ResponseEntity<ApiResponse<*>> {
        return ResponseEntity.status(500).body(ApiResponse(
                statusCode = ApiStatus.E9999.code,
                statusMsg = "${ApiStatus.E9999.msg}(${e.cause?.message})",
                data = null
        ))
    }
}