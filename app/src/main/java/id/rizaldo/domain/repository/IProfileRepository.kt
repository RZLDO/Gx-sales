package id.rizaldo.domain.repository

import id.rizaldo.data.ApiResponse
import id.rizaldo.domain.model.profile.ProfileDataModel
import kotlinx.coroutines.flow.Flow


interface IProfileRepository {
    fun fetchProfile() : Flow<ApiResponse<ProfileDataModel>>
}