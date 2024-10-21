package com.example.login.ui.viewmodels.forms

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope

import com.example.login.data.network.services.GetServiceUser
import kotlinx.coroutines.launch

class PruebaViewModel(
    private val getServiceUser: GetServiceUser
) : ViewModel() {

    fun loadInfoUser() {
        viewModelScope.launch {
            val user = getServiceUser.execute()
            Log.d("USER", user.toString())
        }
    }

    companion object{
        fun provideFactory(getServiceUser: GetServiceUser): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PruebaViewModel(getServiceUser) as T
            }
        }
    }

}