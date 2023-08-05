package com.yin.sms.common.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PhoneNumberValidator : ConstraintValidator<PhoneNumber, String> {

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        val regex = Regex("^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$")
        return regex.matches(value)
    }

    override fun initialize(constraintAnnotation: PhoneNumber?) {
        super.initialize(constraintAnnotation)
    }
}