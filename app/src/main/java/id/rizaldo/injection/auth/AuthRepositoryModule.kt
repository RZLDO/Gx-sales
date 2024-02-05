package id.rizaldo.injection.auth

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rizaldo.data.auth.AuthRepository
import id.rizaldo.domain.repository.IAuthRepository

@Module(includes = [AuthNetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class AuthRepositoryModule {
    @Binds
    abstract fun provideAuthRepository(authRepository: AuthRepository) : IAuthRepository
}
