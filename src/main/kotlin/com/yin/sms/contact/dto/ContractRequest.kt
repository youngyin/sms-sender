package com.yin.sms.contact.dto

import org.intellij.lang.annotations.Pattern
import java.util.UUID

data class ContractRequest(
        @Pattern("^01(?:0|1|[6-9])[.-]?(\\\\d{3}|\\\\d{4})[.-]?(\\\\d{4})\$")
        var phone : String? = null,
        var name : String? = null,
        var id : UUID? = null
){
}