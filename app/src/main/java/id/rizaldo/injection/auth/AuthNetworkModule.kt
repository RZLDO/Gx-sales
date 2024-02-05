package id.rizaldo.injection.auth

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rizaldo.data.auth.datasource.AuthService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class AuthNetworkModule {
    @Provides
    fun provideAuthApiService(retrofit : Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}