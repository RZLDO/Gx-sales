package id.rizaldo.data.leads.response

import com.google.gson.annotations.SerializedName

data class BranchOffice(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)