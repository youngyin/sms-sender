package com.yin.sms.contact.controller

import com.yin.sms.common.response.ApiResponse
import com.yin.sms.contact.dto.ContractRequest
import com.yin.sms.contact.dto.ContractResponse
import com.yin.sms.contact.service.ContractService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contract")
@AllArgsConstructor
class ContractController {

    @Autowired
    private lateinit var contractService: ContractService

    @PostMapping("/save")
    fun save(@RequestBody contractRequest: ContractRequest): ResponseEntity<ApiResponse<ContractRequest>> {
        return ResponseEntity.ok(ApiResponse(contractService.save(contractRequest)))
    }

    @PostMapping("/findAll")
    fun findAll():ResponseEntity<ApiResponse<List<ContractResponse>>> {
        return ResponseEntity.ok(ApiResponse(contractService.findAll()))
    }

}