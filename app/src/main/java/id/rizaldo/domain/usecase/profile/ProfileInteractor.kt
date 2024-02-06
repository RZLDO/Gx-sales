package id.rizaldo.domain.usecase.profile

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.profile.ProfileRepository
import id.rizaldo.domain.model.profile.ProfileDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileInteractor @Inject constructor(
    private val repository : ProfileRepository
) : ProfileUseCase{
    override fun fetchProfile(): Flow<ApiResponse<ProfileDataModel>> = repository.fetchProfile()

}