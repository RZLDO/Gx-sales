package id.rizaldo.data.profile.datasource

import id.rizaldo.data.profile.response.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApiService {
    @GET("profile")
    suspend fun fetchProfile(
        @Header("Authorization") token: String
    ) : ProfileResponse
}