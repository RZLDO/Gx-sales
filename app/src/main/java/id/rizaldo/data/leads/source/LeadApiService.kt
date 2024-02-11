package id.rizaldo.data.leads.source

import id.rizaldo.data.leads.response.LeadsResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface LeadApiService {
    @GET("leads")
    fun fetchLeads(
        @Header("Authorization") token : String,
    ): LeadsResponse
}