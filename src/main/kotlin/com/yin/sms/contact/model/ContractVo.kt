package com.yin.sms.contact.model

import com.yin.sms.contact.dto.ContractRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "CONTRACT")
data class ContractVo(
        @Id
        var id: UUID? = null,
        @Column
        var phone: String? = null,
        @Column
        var name : String? = null,
        @Column
        var updtDt : LocalDateTime? = LocalDateTime.now(),
        @Column
        var regDt : LocalDateTime? = LocalDateTime.now()
) {

    constructor(contractSaveDto: ContractRequest) : this() {
        phone = contractSaveDto.phone
        name = contractSaveDto.name
        id = contractSaveDto.id
    }
}