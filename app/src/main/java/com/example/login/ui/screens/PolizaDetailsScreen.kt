package com.example.login.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.login.components.AppButton
import com.example.login.components.PolizaDetails
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import com.example.login.ui.viewmodels.CrearSolicitudViewModel

@Composable
fun PolizaDetailsScreen(
    poliza: Poliza,
    polizaDetailsViewModel: ViewModel,
    navController: NavHostController,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {

    //Text("DOMINIO: ${poliza.vehiculo.dominio}", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    Column {
        PolizaDetails(poliza)
        AppButton(
            action = {
                crearSolicitudViewModel.reiniciarEstados()
                val polizaJson = gson.toJson(poliza)
                navController.navigate("${Rutas.DatosSiniestro.ruta}/$polizaJson")
            },
            modifier = Modifier.padding(start = 10.dp),
            text = "Solicitud por siniestro"
        )

    }
}