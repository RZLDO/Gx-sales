package id.rizaldo.domain.repository

import id.rizaldo.data.ApiResponse
import id.rizaldo.data.leads.response.Customer
import id.rizaldo.data.leads.response.LeadsResponse
import kotlinx.coroutines.flow.Flow

interface ILeadRepository {
    fun fetchLeads() : Flow<ApiResponse<List<Customer>>>
}