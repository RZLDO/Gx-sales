package id.rizaldo.data.auth.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status : String,
    @SerializedName("token")
    val token : String,
    @SerializedName("type")
    val type : String
)