package com.example.login.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas

@Composable
fun PolizaDetailsScreen(
    poliza: Poliza,
    polizaDetailsViewModel: ViewModel,
    navController: NavHostController
) {

    Text("DOMINIO: ${poliza.dominio}", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    Button(
        onClick = {
            val polizaJson = gson.toJson(poliza)
            navController.navigate("${Rutas.SolicitudPolizaScreen.ruta}/$polizaJson")
        },
        ) {
        Text("Iniciar Solicitud")
    }
}