package id.rizaldo.injection.profile

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rizaldo.data.profile.ProfileRepository
import id.rizaldo.domain.repository.IProfileRepository

@Module(includes = [ProfileNetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class ProfileRepositoryModule {
    @Binds
    abstract fun provideProfileRepository(profileRepository: ProfileRepository) : IProfileRepository
}