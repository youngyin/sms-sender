package com.yin.sms.contact.service

import com.yin.sms.contact.dto.ContractRequest
import com.yin.sms.contact.dto.ContractResponse
import com.yin.sms.contact.model.ContractVo
import com.yin.sms.contact.repository.ContractRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.List

@Service
class ContractServiceImpl: ContractService {
    @Autowired
    private lateinit var contractRepository : ContractRepository

    override fun save(saveDto: ContractRequest) : ContractRequest {
        contractRepository.save(
            ContractVo( id = UUID.randomUUID(), phone = saveDto.phone, name = saveDto.name)
        )
        return saveDto
    }

    override fun findAll(): List<ContractResponse> {
        return contractRepository.findAll().map { vo ->
            ContractResponse(phone = vo.phone, name = vo.name)
        }
    }
}