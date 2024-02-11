package id.rizaldo.data.leads.response

import com.google.gson.annotations.SerializedName

data class LeadsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<Customer>,
    @SerializedName("pagination")
    val pagination: Pagination
)