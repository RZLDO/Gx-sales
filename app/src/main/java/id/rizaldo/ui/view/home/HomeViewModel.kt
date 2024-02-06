package id.rizaldo.ui.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.rizaldo.domain.usecase.profile.ProfileUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: ProfileUseCase
) : ViewModel(){

    fun fetchProfile(){
        viewModelScope.launch {

        }
    }
}