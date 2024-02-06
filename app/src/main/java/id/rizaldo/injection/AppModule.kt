package id.rizaldo.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.rizaldo.domain.usecase.auth.AuthInteractor
import id.rizaldo.domain.usecase.auth.AuthUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideAuthUseCase(authInteractor: AuthInteractor): AuthUseCase

}