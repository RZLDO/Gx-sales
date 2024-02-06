package id.rizaldo.injection.profile

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.rizaldo.data.profile.datasource.ProfileApiService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ProfileNetworkModule {
    @Provides
    fun provideProfileNetworkService(retrofit: Retrofit) : ProfileApiService{
        return retrofit.create(ProfileApiService::class.java)
    }
}