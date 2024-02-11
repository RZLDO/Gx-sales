package id.rizaldo.domain.usecase.lead

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.leads.response.Customer
import kotlinx.coroutines.flow.Flow

interface LeadUseCase {
    fun fetchLeads(): Flow<ApiResponse<List<Customer>>>
}