package com.yin.sms.common.converter

import com.yin.sms.security.service.CryptService
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired

@Converter
@AllArgsConstructor
class PhoneNumberConverter : AttributeConverter<String, String> {

    @Autowired
    private lateinit var cryptService: CryptService

    override fun convertToDatabaseColumn(attribute: String?): String {
        return cryptService.encrypt(attribute?:"")
    }

    override fun convertToEntityAttribute(dbData: String?): String {
        return cryptService.decrypt(dbData?:"")
    }
}