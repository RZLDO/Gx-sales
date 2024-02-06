package id.rizaldo.data.profile.response

import com.google.gson.annotations.SerializedName

data class ProfileDataResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email : String,
)