package com.yin.sms.contact.dto

import com.yin.sms.contact.model.ContractVo
import org.intellij.lang.annotations.Pattern

class ContractResponse(){
        @Pattern("^01(?:0|1|[6-9])[.-]?(\\\\d{3}|\\\\d{4})[.-]?(\\\\d{4})\$")
        private var phone : String? = null
        private var name : String? = null

        constructor(contractVo: ContractVo) : this() {
                phone = contractVo.phone
                name = contractVo.name
        }
}