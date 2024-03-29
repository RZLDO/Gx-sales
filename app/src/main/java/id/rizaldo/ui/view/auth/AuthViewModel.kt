package id.rizaldo.ui.view.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.rizaldo.data.ApiResponse
import id.rizaldo.domain.model.auth.PostSignIn
import id.rizaldo.domain.usecase.auth.AuthUseCase
import id.rizaldo.ui.view.auth.extension.AuthUiState
import id.rizaldo.ui.view.auth.extension.failure
import id.rizaldo.ui.view.auth.extension.loading
import id.rizaldo.ui.view.auth.extension.loginSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val useCase: AuthUseCase
) : ViewModel() {
    val mutableUiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = mutableUiState.asStateFlow()
    fun signIn(data : PostSignIn){
        viewModelScope.launch {
            useCase.signIn(data).collect{
                when(it){
                    is ApiResponse.Loading -> {
                        loading()
                    }
                    is ApiResponse.CustomError -> {
                        failure()
                    }
                    is ApiResponse.Success -> {
                        loginSuccess()
                    }
                    else -> {}
                }
            }
        }
    }
}