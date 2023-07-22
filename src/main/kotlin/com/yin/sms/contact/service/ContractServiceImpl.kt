package com.yin.sms.contact.service

import com.yin.sms.contact.dto.ContractRequest
import com.yin.sms.contact.dto.ContractResponse
import com.yin.sms.contact.model.ContractVo
import com.yin.sms.contact.repository.ContractRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContractServiceImpl: ContractService {
    @Autowired
    private lateinit var contractRepository : ContractRepository

    override fun save(saveDto: ContractRequest) : ContractRequest {
        saveDto.id = UUID.randomUUID()
        contractRepository.save(ContractVo(saveDto))
        return saveDto
    }

    override fun searchAll() : List<ContractResponse> {
        return contractRepository.findAll()
                .map { vo -> ContractResponse(vo) }
    }
}