package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.login.components.MyAppTheme
import com.example.login.data.network.services.GetStatus
import com.example.login.data.network.RetrofitClient
import com.example.login.navigation.AppNavigation
import com.example.login.ui.viewmodels.LoadingViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                AppNavigation()
            }
        }
    }
}


