package id.rizaldo.domain.model.profile

import id.rizaldo.data.profile.response.ProfileDataResponse

object ProfileMapper {
    fun mapResponseToDomain (data : ProfileDataResponse) : ProfileDataModel{
        return ProfileDataModel(
            id = data.id,
            name = data.name,
            email = data.email
        )
    }
}