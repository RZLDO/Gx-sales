package id.rizaldo.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.rizaldo.domain.usecase.auth.AuthInteractor
import id.rizaldo.domain.usecase.auth.AuthUseCase
import id.rizaldo.domain.usecase.profile.ProfileInteractor
import id.rizaldo.domain.usecase.profile.ProfileUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideAuthUseCase(authInteractor: AuthInteractor): AuthUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideProfileUseCase(profileInteractor: ProfileInteractor): ProfileUseCase

}