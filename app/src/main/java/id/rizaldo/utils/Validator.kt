package id.rizaldo.utils

import id.rizaldo.R

object Validator {
    fun isEmailValid(email: String): ValidationResult {
        if(email.isEmpty()){
            return ValidationResult(isValid = false, stringRes =  R.string.error_empty_text)
        }else if (email.isNotEmpty()) {
            val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
            return ValidationResult(
                isValid = emailRegex.matches(email), stringRes = R.string.error_text_email
            )
        }
        return ValidationResult(isValid = true, stringRes = R.string.error_empty_text)
    }

    fun isTextEmpty(text : String) : ValidationResult{
        return if(text.isEmpty()){
            ValidationResult(isValid = false, stringRes = R.string.error_empty_text)
        }else {
            ValidationResult(isValid = true, stringRes = 0)
        }
    }
}
