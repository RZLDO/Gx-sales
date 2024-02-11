package id.rizaldo.ui.view.profile

import android.provider.ContactsContract.Profile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.rizaldo.data.ApiResponse
import id.rizaldo.domain.usecase.profile.ProfileUseCase
import id.rizaldo.ui.view.profile.extension.ProfileUiState
import id.rizaldo.ui.view.profile.extension.fetchLoading
import id.rizaldo.ui.view.profile.extension.fetchSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: ProfileUseCase
)  : ViewModel(){
    val mutableUiState = MutableStateFlow(ProfileUiState())
    val uiState : StateFlow<ProfileUiState> = mutableUiState.asStateFlow()
    init {
        fetchProfile()
    }
    private fun fetchProfile(){
        viewModelScope.launch {
            useCase.fetchProfile().collect{ result ->
                when(result){
                    is ApiResponse.Loading -> {
                        fetchLoading()
                    }
                    is ApiResponse.Success -> {
                        fetchSuccess(result.data)
                    }
                    is ApiResponse.CustomError -> {

                    }
                    else -> {}
                }
            }
        }
    }
}