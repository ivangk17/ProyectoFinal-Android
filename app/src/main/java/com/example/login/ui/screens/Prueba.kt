package com.example.login.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.ui.viewmodels.forms.PruebaViewModel

@Composable
fun Prueba(navController: NavController, pruebaViewModel: PruebaViewModel){
    Button(
        onClick = {
            pruebaViewModel.loadInfoUser()
        }
    ) {
        Text("Traer info")
    }
}