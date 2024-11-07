package com.example.login.ui.screens.forms

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
import androidx.navigation.NavController
import com.example.login.components.DatePicker
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.datosSiniestros.HuboDenuncia
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.InformacionAdicionalViewModel
import com.example.login.utilities.showToastError

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

                DatePicker(
                    label = "Vigencia hasta",
                    valor = viewModel.vigenciaHasta,
                    error = viewModel.errorVigenciaHasta,
                    onDateSelected = { newValue -> viewModel.setVigencia(newValue) }
                )
            }

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
                        val solicitud = viewModel.crearSolicitudPoliza()
                        val polizaJson = gson.toJson(poliza)

                        if (solicitud != null) {
                            crearSolicitudViewModel.envioInformacionAdicional(solicitud)
                            navController.navigate("${Rutas.LoadingScreen.ruta}/$polizaJson/${Rutas.DatosPropietarioVehiculoAsegurado.ruta}")
                        } else {

                            showToastError(context, "error: No se puede crear la solicitud")
                            Log.d("solicitud", "no se creo")
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Siguiente")
                }
            }
        }
    }
}