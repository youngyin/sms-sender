package com.yin.sms.contact.service

import com.yin.sms.contact.dto.ContractRequest
import com.yin.sms.contact.dto.ContractResponse

interface ContractService {
    fun save(saveDto: ContractRequest) : ContractRequest
    fun searchAll() : List<ContractResponse>
}