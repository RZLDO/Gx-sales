package id.rizaldo.data.leads.response

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
