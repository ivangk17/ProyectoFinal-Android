package com.example.login.ui.screens.datosperfil

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CambiarDatosPerfilViewModel
import com.example.login.utilities.showToastError

@Composable
fun CambiarDatosPerfilScreen(
    viewModel: CambiarDatosPerfilViewModel,
    navController: NavHostController
) {
    val context = LocalContext.current
    val user = viewModel.loadInfoUser()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {

            items(viewModel.campos.size) { index ->
                val campo = viewModel.campos[index]

                FieldStringForms(
                    label = campo.label,
                    value = campo.value,
                    error = campo.error,
                    onValueChange = { newValue -> viewModel.onCampoChange(index, newValue) }
                )
            }

            item {
                Button(
                    onClick = {
                        if (viewModel.editarPerfil(context)){
                            navController.navigate(route = Rutas.DatosPropietarioVehiculoTercero.ruta)
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Cambiar mis datos")
                }
            }
        }
    }

}