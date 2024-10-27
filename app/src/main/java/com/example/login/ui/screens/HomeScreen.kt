package com.example.login.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.ui.viewmodels.HomeViewModel
import com.example.login.components.PolizaCard
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.tokens.Utility
import com.google.gson.Gson

val gson = Gson()

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    val user = Utility().decodeJWT(Token.token)
    val scope = rememberCoroutineScope()
    val polizas by homeViewModel.Polizas

    LaunchedEffect(Unit) {
        homeViewModel.loadPolizas()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (polizas.isNotEmpty()) {
            polizas.forEach { poliza ->
                PolizaCard(poliza){
                    Log.e("poliza", poliza.vehiculo.dominio)
                    val polizaJson = gson.toJson(poliza)
                    navController.navigate("${Rutas.PolizaDetalleScreen.ruta}/$polizaJson")
                }
            }
        } else {
            Text(
                text = "Loading polizas...",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


