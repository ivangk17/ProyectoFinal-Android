package com.example.login

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.login.components.MyAppTheme
import com.example.login.data.network.services.LoginService
import com.example.login.ui.screens.MainScreen
import com.example.login.ui.viewmodels.mainactivityviewmodel.MainActivityViewModel

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginService: LoginService

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            val mainActivityViewModel: MainActivityViewModel = hiltViewModel()

            MyAppTheme {

                MainScreen(mainActivityViewModel)
            }
        }
    }
}


