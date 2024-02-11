package id.rizaldo.data.leads.response

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("count")
    val count: Int,
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("perPage")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)