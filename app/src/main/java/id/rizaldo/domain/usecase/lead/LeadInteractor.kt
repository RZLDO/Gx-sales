package id.rizaldo.domain.usecase.lead

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.leads.LeadsRepository
import id.rizaldo.data.leads.response.Customer
import id.rizaldo.domain.repository.ILeadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LeadInteractor @Inject constructor(
    private val repository: ILeadRepository
) : LeadUseCase{
    override fun fetchLeads(): Flow<ApiResponse<List<Customer>>> = repository.fetchLeads()
}