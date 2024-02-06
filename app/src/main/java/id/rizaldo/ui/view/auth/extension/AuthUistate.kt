package id.rizaldo.ui.view.auth.extension

import id.rizaldo.R
import id.rizaldo.ui.view.auth.AuthViewModel
import id.rizaldo.utils.ValidationResult
import id.rizaldo.utils.Validator
import kotlinx.coroutines.flow.update

data class AuthUiState(
    val isError : Boolean = false,
    val isSuccess : Boolean = false,
    val isLoading : Boolean = false,

    // Validation
    var emailValidation: ValidationResult? = null,
    val passwordValidation : ValidationResult? = null
)
fun AuthViewModel.validateEmail(data : String){
    mutableUiState.update {
        it.copy(
            emailValidation = Validator.isEmailValid(data)
        )
    }
}
fun AuthViewModel.validatePassword(data : String){
    mutableUiState.update {
        it.copy(
            emailValidation = Validator.isTextEmpty(data)
        )
    }
}

fun AuthViewModel.loginSuccess(){
    mutableUiState.update {
        it.copy(
            isError = false,
            isSuccess = true,
            isLoading = false,
        )
    }
}
fun AuthViewModel.failure(){
    mutableUiState.update {
        it.copy(
            isError = true,
            isSuccess = false,
            isLoading = false,
        )
    }
}
fun AuthViewModel.loading(){
    mutableUiState.update {
        it.copy(
            isError = false,
            isSuccess = false,
            isLoading = true,
        )
    }
}