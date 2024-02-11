package id.rizaldo.data.leads

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.leads.response.Customer
import id.rizaldo.data.leads.source.LeadDataSource
import id.rizaldo.domain.model.profile.ProfileMapper
import id.rizaldo.domain.repository.ILeadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LeadsRepository @Inject constructor(
    private val source : LeadDataSource
) : ILeadRepository{
    override fun fetchLeads(): Flow<ApiResponse<List<Customer>>> = flow{
        emit(ApiResponse.Loading)
        when( val response = source.fetchLeads().first()){
            is ApiResponse.Success -> emit(ApiResponse.Success(response.data.data))
            is ApiResponse.CustomError -> emit(ApiResponse.CustomError(response.error))
            else -> {}
        }
    }
}