package com.yin.sms.contact.model

import com.yin.sms.common.converter.PhoneNumberConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.*

@Entity(name = "CONTRACT")
data class ContractVo(
        @Id
        var id: UUID? = null,
        @Column
        @Convert(converter = PhoneNumberConverter::class)
        var phone: String? = null,
        @Column
        var name : String? = null,
        @Column
        var updtDt : LocalDateTime? = LocalDateTime.now(),
        @Column
        var regDt : LocalDateTime? = LocalDateTime.now()
)