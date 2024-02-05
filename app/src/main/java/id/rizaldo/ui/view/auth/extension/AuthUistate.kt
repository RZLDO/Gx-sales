package id.rizaldo.ui.view.auth.extension

import id.rizaldo.ui.view.auth.AuthViewModel
import kotlinx.coroutines.flow.update

data class AuthUiState(
    val isError : Boolean = false,
    val isSuccess : Boolean = false,
    val isLoading : Boolean = false
)

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