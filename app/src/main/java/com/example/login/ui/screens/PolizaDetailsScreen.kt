package com.example.login.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import com.example.login.data.models.Poliza

@Composable
fun PolizaDetailsScreen(poliza: Poliza, polizaDetailsViewModel: ViewModel) {

    Text("DOMINIO: ${poliza.dominio}", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    Button(
        onClick = {

        },
        ) {
        Text("Iniciar Solicitud")
    }
}