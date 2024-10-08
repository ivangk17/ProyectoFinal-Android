package com.example.login.ui.screens

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
import com.example.login.tokens.Token
import com.example.login.tokens.Utility

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
        // Recorremos las pólizas y mostramos cada una en una tarjeta
            polizas.forEach { poliza ->
                PolizaCard(poliza)
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


