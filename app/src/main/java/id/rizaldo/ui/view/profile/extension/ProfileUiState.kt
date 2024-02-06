package id.rizaldo.ui.view.profile.extension

import id.rizaldo.domain.model.profile.ProfileDataModel

data class ProfileUiState(
    val isLoading : Boolean = false,
    val isError : Boolean = false,
    val isSuccess : Boolean = false,

    // data profile
    val profileData : ProfileDataModel? = null
)

