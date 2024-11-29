package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.login.components.AppButton
import com.example.login.components.DropdownMenuSample
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.InformacionAdicionalViewModel

@Composable
fun InformacionAdicional(
    navController: NavController,
    viewModel: InformacionAdicionalViewModel,
    poliza: Poliza,
    crearSolicitudViewModel: CrearSolicitudViewModel
){
    val options = HuboDenuncia.entries
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.camposCheckeables.size){ index ->
                val campo = viewModel.camposCheckeables[index]
                SwitchCustom(
                    checked = campo.value.value,
                    onCheckedChange = { newState -> viewModel.onSwitchChange(index, newState) },
                    label = campo.label
                )
            }

            item {
                DropdownMenuSample(
                    title = "Seleccionar si hubo denuncia",
                    options = options,
                    selectedOption = viewModel.huboDenunciaSeleccion.value,
                    onOptionSelected = { viewModel.huboDenunciaSeleccion.value = it },
                    label = { it.displayName }
                )
            }

            item {
                AppButton(
                    action = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        val polizaJson = gson.toJson(poliza)

                        Log.d("Solicitud", solicitud.datosSiniestro.toString())
                        crearSolicitudViewModel.envioInformacionAdicional(solicitud)
                        navController.navigate("${Rutas.LoadingScreen.ruta}/$polizaJson/${Rutas.DatosPropietarioVehiculoAsegurado.ruta}")
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Siguiente")

            }
        }
    }
}