package id.rizaldo.data.profile

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.profile.datasource.ProfileDataSource
import id.rizaldo.domain.model.profile.ProfileDataModel
import id.rizaldo.domain.model.profile.ProfileMapper
import id.rizaldo.domain.repository.IProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val source : ProfileDataSource
):IProfileRepository{
    override fun fetchProfile(): Flow<ApiResponse<ProfileDataModel>>  = flow{
        emit(ApiResponse.Loading)
        when( val response = source.fetchProfile().first()){
            is ApiResponse.Success -> emit(ApiResponse.Success(ProfileMapper.mapResponseToDomain(response.data.data)))
            is ApiResponse.CustomError -> emit(ApiResponse.CustomError(response.error))
            else -> {}
        }
    }
}