package com.example.login.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.network.services.GetServicePolizas
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PolizaDetailsViewModel @Inject constructor(
    private val getServicePolizas: GetServicePolizas
): ViewModel() {
}