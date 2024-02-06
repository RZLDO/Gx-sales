package id.rizaldo.domain.usecase.auth

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.auth.response.LoginResponse
import id.rizaldo.domain.model.auth.PostSignIn
import kotlinx.coroutines.flow.Flow


interface AuthUseCase {
    fun signIn(data : PostSignIn) : Flow<ApiResponse<LoginResponse>>
}