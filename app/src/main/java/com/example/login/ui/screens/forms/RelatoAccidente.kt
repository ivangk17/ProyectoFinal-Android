package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.components.MultipleLine
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.viewmodels.forms.DatosAdicionalesViewModel
import com.example.login.ui.viewmodels.forms.RelatoAccidenteViewModel

@Composable
fun RelatoAccidente(navController: NavController, viewModel: RelatoAccidenteViewModel, poliza: Poliza){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        MultipleLine(
            "Relato del accidente",
            viewModel.relatoAccidente,
            onValueChange = { newValue -> viewModel.onRelatoChange(newValue) },
            error = viewModel.errorRelatoAccidente
        )

        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitud()
                if (solicitud != null) {
                    Log.d("SOLICITUD", viewModel.solicitud.datosSiniestro.relato.toString())
                } else {
                    Log.d("solicitud", "no se creo")
                }
            }
        ) {
            Text("Siguiente")
        }
    }
}