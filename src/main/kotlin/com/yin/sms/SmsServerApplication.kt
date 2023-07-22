package com.yin.sms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmsServerApplication

fun main(args: Array<String>) {
    runApplication<SmsServerApplication>(*args)
}
