package com.example.login.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.network.services.GetServicePolizas
import com.example.login.data.network.services.GetServiceUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getServiceUser: GetServiceUser
): ViewModel() {

    var user = mutableStateOf(UserInfoResponse())

    fun loadInfoUser(): MutableState<UserInfoResponse> {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
        }
        return  user
    }

}