package com.yin.sms.security.service

import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Service
class AesCbcServiceImpl: CryptService {
    private val SECRET_KEY = "kjv1SetOIwL3Y6WS"
    private val SECRET_IV = "O91BPZw0f7qAVTlZ"

    private fun getCipher(opMode: Int): Cipher{
        val iv = IvParameterSpec(SECRET_IV.toByteArray())
        val key = SecretKeySpec(SECRET_KEY.toByteArray(), "AES")

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(opMode, key, iv)
        return cipher
    }

    override fun encrypt(plainStr: String): String {
        try {
            val encrypted = getCipher(Cipher.ENCRYPT_MODE).doFinal(plainStr.toByteArray())
            return Base64.getEncoder().encodeToString(encrypted)
        } catch (e : Exception){
            e.printStackTrace()
            throw e
        }
    }

    override fun decrypt(cipherStr: String): String {
        try {
            val decoded = Base64.getDecoder().decode(cipherStr)
            val decrypted = getCipher(Cipher.DECRYPT_MODE).doFinal(decoded)
            return decrypted.decodeToString()
        } catch (e : Exception){
            e.printStackTrace()
            throw e
        }
    }
}