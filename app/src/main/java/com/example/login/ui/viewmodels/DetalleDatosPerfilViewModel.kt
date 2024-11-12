package com.example.login.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.network.services.GetServiceUser
import kotlinx.coroutines.launch

class DetalleDatosPerfilViewModel(
    private val getServiceUser: GetServiceUser
): ViewModel() {

    var user = mutableStateOf(UserInfoResponse())

    fun loadInfoUser(): MutableState<UserInfoResponse> {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
        }
        return  user
    }

    companion object{
        fun provideFactory(getServiceUser: GetServiceUser): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetalleDatosPerfilViewModel(getServiceUser) as T
            }
        }
    }
}