package com.example.login.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.network.GetStatus
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getStatus: GetStatus
) : ViewModel() {

    var _status = mutableStateOf<Boolean>(false)
    var _attemps = mutableStateOf<Int>(0)
    var _showLoading = mutableStateOf<Boolean>(true)

    fun loadStatus() {
        viewModelScope.launch {
            _attemps.value++
            val status = getStatus.execute()
            if (status) {
                _status.value = true;
            }
        }
    }

    fun setShowLoading(state: Boolean) {
        _showLoading.value = state;
    }

    fun getStatus(): Boolean {
        return _status.value
    }

    fun getShowLoading(): Boolean {
        return _showLoading.value
    }

    fun getAttemps(): Int {
        return _attemps.value
    }

    fun setAttemps(attemps: Int) {
        _attemps.value = attemps
    }


    companion object {
        fun provideFactory(getStatus: GetStatus): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainActivityViewModel(getStatus) as T
                }
            }
    }
}