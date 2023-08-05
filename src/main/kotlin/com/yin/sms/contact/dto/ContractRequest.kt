package com.yin.sms.contact.dto

import com.yin.sms.common.validator.PhoneNumber

data class ContractRequest(
        @field:PhoneNumber(message = "유효하지 않은 전화번호입니다.")
        val phone : String,
        val name : String?,
)