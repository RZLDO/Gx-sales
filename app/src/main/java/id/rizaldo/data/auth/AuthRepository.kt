package id.rizaldo.data.auth

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.auth.datasource.AuthDataSource
import id.rizaldo.data.auth.response.LoginResponse
import id.rizaldo.domain.model.auth.PostSignIn
import id.rizaldo.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val dataSource : AuthDataSource
) : IAuthRepository{
    override fun signIn(data: PostSignIn): Flow<ApiResponse<LoginResponse>> = flow{
        emit(ApiResponse.Loading)
        when(val response = dataSource.signIn(data = data).first()){
            is ApiResponse.CustomError -> emit(ApiResponse.CustomError(response.error))
            is ApiResponse.Success -> emit(ApiResponse.Success(response.data))
            else ->{}
        }
    }

}