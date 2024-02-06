package id.rizaldo.domain.usecase.auth

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.auth.response.LoginResponse
import id.rizaldo.domain.model.auth.PostSignIn
import id.rizaldo.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val repository: IAuthRepository
) : AuthUseCase{
    override fun signIn(data: PostSignIn): Flow<ApiResponse<LoginResponse>> = repository.signIn(data = data)
}