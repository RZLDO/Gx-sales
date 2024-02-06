package id.rizaldo.data.profile.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse (
    @SerializedName("status")
    val status : String,
    @SerializedName("message")
    val message : String,
    @SerializedName("data")
    val data : ProfileDataResponse
)


