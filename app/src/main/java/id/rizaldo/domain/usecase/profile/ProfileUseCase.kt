package id.rizaldo.domain.usecase.profile

import id.rizaldo.data.ApiResponse
import id.rizaldo.domain.model.profile.ProfileDataModel
import kotlinx.coroutines.flow.Flow

interface ProfileUseCase {
    fun fetchProfile() : Flow<ApiResponse<ProfileDataModel>>
}