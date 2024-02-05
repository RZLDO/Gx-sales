package id.rizaldo.data.auth.datasource

import id.rizaldo.data.auth.response.LoginResponse
import id.rizaldo.domain.model.auth.PostSignIn
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {
    @POST("/login")
    suspend fun signIn(
        @Body data : PostSignIn
    ): LoginResponse
}