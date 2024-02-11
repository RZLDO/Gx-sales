package id.rizaldo.ui.view.profile.extension

import android.provider.ContactsContract.Profile
import id.rizaldo.domain.model.profile.ProfileDataModel
import id.rizaldo.ui.view.profile.ProfileViewModel
import kotlinx.coroutines.flow.update

data class ProfileUiState(
    val isLoading : Boolean = false,
    val isError : Boolean = false,
    val isSuccess : Boolean = false,

    // data profile
    val profileData : ProfileDataModel = ProfileDataModel.fakes()
)

fun ProfileViewModel.fetchSuccess(data : ProfileDataModel){
    mutableUiState.update {
        it.copy(
            isLoading = false,
            isError = false,
            isSuccess = true,
            profileData = data
        )
    }
}
fun ProfileViewModel.fetchFailure(errorMessage : String){
    mutableUiState.update {
        it.copy(
            isLoading = false,
            isError = true,
            isSuccess = true,
        )
    }
}
fun ProfileViewModel.fetchLoading(){
    mutableUiState.update {
        it.copy(
            isLoading = true,
            isError = false,
            isSuccess = false,
        )
    }
}


