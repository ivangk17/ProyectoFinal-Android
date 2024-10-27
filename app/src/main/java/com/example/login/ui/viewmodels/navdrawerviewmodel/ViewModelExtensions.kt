package com.example.login.ui.viewmodels.navdrawerviewmodel

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> ComponentActivity.getViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory).get(T::class.java)
}
