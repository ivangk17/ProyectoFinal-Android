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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.viewmodels.MainActivityViewModel
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(viewModel: MainActivityViewModel) {
    var showLoading by remember { mutableStateOf(true) }
    val MAX_ATTEMPTS = 10

    LaunchedEffect(showLoading) {
        if (showLoading) {
            while (viewModel.getAttemps() < MAX_ATTEMPTS && !viewModel.getStatus()) {
                viewModel.loadStatus()
                delay(1000)
                if (viewModel.getStatus()) {
                    showLoading = false
                }
            }
            if (viewModel.getAttemps() >= MAX_ATTEMPTS) {
                showLoading = false
            }
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
            if (viewModel.getStatus()) {
                //ACA deberia ir directamente al AppNavigation

                Button(onClick = { /* Navegar a otra pantalla */ }) {
                    Text("Conectado")
                }
            } else {
                Button(onClick = {
                    viewModel.setAttemps(0) // Reinicia los intentos
                    showLoading = true // Muestra el cargador de nuevo
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

