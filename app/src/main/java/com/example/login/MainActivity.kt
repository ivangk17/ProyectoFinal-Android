package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.network.services.GetStatus
import com.example.login.data.network.RetrofitClient
import com.example.login.navigation.AppNavigation
import com.example.login.ui.viewmodels.MainActivityViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModelFactory

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModel.provideFactory(
            GetStatus(RetrofitClient.apiService)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val drawerViewModel = ViewModelProvider(this, DrawerViewModelFactory())
                .get(DrawerViewModel::class.java)

            AppNavigation(drawerViewModel)
        }
    }
}


