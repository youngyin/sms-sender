package com.yin.sms.contact.controller

import com.yin.sms.common.response.ApiStatus
import com.yin.sms.contact.model.ContractVo
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
internal class ContractControllerTest {

    @Autowired
    private lateinit var mvcMock : MockMvc

    private val sample = ContractVo(phone = "010-1111-2222", name = "sample")

    @Test
    fun save() {
        val json = """
           {
            "phone" : "${sample.phone}", 
            "name" : "${sample.name}"
           } 
        """

        mvcMock.perform(
                MockMvcRequestBuilders.post("/contract/save")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("\$.statusCode").value(ApiStatus.E0000.code))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.statusMsg").value(ApiStatus.E0000.msg))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.data.phone").value(sample.phone))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.data.name").value(sample.name))
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    @Transactional
    fun searchAll() {
        mvcMock.perform(
                MockMvcRequestBuilders.post("/contract/selectAll")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("\$.statusCode").value(ApiStatus.E0000.code))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.statusMsg").value(ApiStatus.E0000.msg))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.data").exists())
                .andDo(MockMvcResultHandlers.print())
    }
}