package id.rizaldo.data.leads.response

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("id")
    val id: Int,
    @SerializedName("number")
    val number: String,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("companyName")
    val companyName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("IDNumber")
    val IDNumber: String,
    @SerializedName("IDNumberPhoto")
    val IDNumberPhoto: String,
    @SerializedName("generalNotes")
    val generalNotes: String,
    @SerializedName("branchOffice")
    val branchOffice: BranchOffice,
    @SerializedName("status")
    val statusCustomer: Status,
    @SerializedName("probability")
    val probability: Probability,
    @SerializedName("type")
    val type: Type,
    @SerializedName("channel")
    val channel: Channel,
    @SerializedName("media")
    val media: Media,
    @SerializedName("source")
    val source: Source,
    @SerializedName("createdAt")
    val createdAt: String
)

