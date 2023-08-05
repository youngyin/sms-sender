package com.yin.sms.common.validator

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PhoneNumberValidator::class])
annotation class PhoneNumber(
        val message : String = "{PhoneNumber}",
        val groups : Array<KClass<*>> = [],
        val payload : Array<KClass<out Payload>> = []
)
