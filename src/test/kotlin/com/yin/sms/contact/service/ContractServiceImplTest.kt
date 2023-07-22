package com.yin.sms.contact.service

import com.yin.sms.contact.dto.ContractRequest
import com.yin.sms.contact.repository.ContractRepository
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ContractServiceImplTest {

    @Autowired
    private lateinit var contractRepository : ContractRepository

    @Autowired
    private lateinit var contractService: ContractService

    @Test
    @Transactional
    fun `save-select`() {
        val request = ContractRequest(phone = "010-1111-2222", name = "user")
        contractService.save(request)
        val contract = contractRepository.findAll().stream().findFirst()

        assert(contract.isPresent)
        assert(contract.get().name == request.name)
        assert(contract.get().phone == request.phone)
    }
}