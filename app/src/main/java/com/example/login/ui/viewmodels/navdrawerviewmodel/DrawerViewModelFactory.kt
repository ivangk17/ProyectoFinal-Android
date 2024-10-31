package com.example.login.ui.viewmodels.navdrawerviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DrawerViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DrawerViewModel::class.java)) {
            return DrawerViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
