package com.example.login.ui.viewmodels.mainactivityviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.network.services.LoginService

class MainActivityViewModelFactory(private val loginService: LoginService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(loginService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
