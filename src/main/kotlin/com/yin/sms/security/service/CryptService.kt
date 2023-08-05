package com.yin.sms.security.service

interface CryptService {
    fun encrypt(plainStr: String): String
    fun decrypt(cipherStr: String): String
}