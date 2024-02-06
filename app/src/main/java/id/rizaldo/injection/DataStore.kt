package id.rizaldo.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.rizaldo.config.UserTokenManager
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DataStore {
    @Provides
    @Singleton
    fun provideUserTokenManager(@ApplicationContext context: Context): UserTokenManager {
        return UserTokenManager(context = context)
    }
}