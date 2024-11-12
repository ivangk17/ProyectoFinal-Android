package com.example.login.ui.viewmodels.solicitudesviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.network.services.SolicitudesRepositoryImpl

class SolicitudesViewModelFactory(private val repository: SolicitudesRepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SolicitudesViewModel::class.java)) {
            return SolicitudesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}