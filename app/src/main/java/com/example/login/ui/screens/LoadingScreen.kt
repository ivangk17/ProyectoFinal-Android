package com.example.login.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.ui.viewmodels.LoadingViewModel
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    poliza: Poliza,
    viewModel: LoadingViewModel,
    navController: NavController,
    nextRoute: String,
) {
    var showLoading by remember { mutableStateOf(true) }
    var showRetryButton by remember { mutableStateOf(false) }
    val MAX_ATTEMPTS = 10

    LaunchedEffect(showLoading) {
        if (showLoading) {
            while (viewModel.getAttemps() < MAX_ATTEMPTS && !viewModel.getStatus()) {
                viewModel.loadStatus()
                delay(100)
            }
            if (viewModel.getStatus()) {
                if(nextRoute == "solicitudEnviada"){
                    navController.navigate("${nextRoute}"){
                        popUpTo(Rutas.LoadingScreen.ruta) { inclusive = true }
                    }
                }else{
                    navController.navigate("${nextRoute}/${gson.toJson(poliza)}"){
                        popUpTo("${Rutas.LoadingScreen.ruta}/{polizaJson}/{nextRoute}") { inclusive = true }
                    }
                }

            } else {
                showRetryButton = true
            }
            showLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        if (showLoading) {
            IndeterminateCircularIndicator()
        } else {
            if (showRetryButton) {
                Button(onClick = {
                    viewModel.setAttemps(0)
                    showLoading = true
                    showRetryButton = false
                }) {
                    Text("En este momento no hay conexión, reintentar")
                }
            }
        }
    }
}


@Composable
fun IndeterminateCircularIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

