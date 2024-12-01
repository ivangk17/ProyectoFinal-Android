package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.components.MultipleLine
import com.example.login.navigation.Rutas
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.RelatoAccidenteViewModel
import com.example.login.utilities.showToastError

@Composable
fun RelatoAccidente(
    navController: NavController,
    viewModel: RelatoAccidenteViewModel,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        MultipleLine(
            stringResource(R.string.relato_accidente),
            viewModel.relatoAccidente,
            onValueChange = { newValue -> viewModel.onRelatoChange(newValue) },
            error = viewModel.errorRelatoAccidente
        )

        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitud()
                if (solicitud != null) {
                    crearSolicitudViewModel.relatoAccidente(solicitud)
                    navController.navigate(Rutas.LugarAsistencia.ruta)
                } else {
                    showToastError(context, "error: No se puede crear la solicitud")
                    Log.d("solicitud", "no se creo")
                }
            }
        ) {
            Text(stringResource(R.string.siguiente))
        }
    }
}