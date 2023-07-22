package com.yin.sms.contact.repository

import com.yin.sms.contact.model.ContractVo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ContractRepository : JpaRepository<ContractVo, UUID>{
}