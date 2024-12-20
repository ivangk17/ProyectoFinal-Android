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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.components.AppButton
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.UsoDelVehiculo
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoAseguradoViewModel
import com.example.login.utilities.showToastError

@Composable
fun DatosPropietarioVehiculoAsegurado(
    navController: NavController,
    viewModel: DatosPropietarioVehiculoAseguradoViewModel,
    polizaParametro: Poliza,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val context = LocalContext.current
    val optionsUsoVehiculo = UsoDelVehiculo.entries //esto devuelve una lista de opciones
    val optionsColor = ColorVehiculo.entries
    val optionsSexo = Sexo.entries
    val user =
        viewModel.loadInfoUser(polizaParametro) //TODO NO BORRAR ESTA VARIABLE (porque sino no carga la info del usuario logueado)

    Column(
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

                if (index == 8) {
                    DropdownMenuSample(
                        title = stringResource(R.string.sexo_titulo),
                        options = optionsSexo,
                        selectedOption = viewModel.sexoSeleccionado.value,
                        onOptionSelected = { viewModel.sexoSeleccionado.value = it },
                        label = { it.displayName }
                    )
                }
            }

            item {
                DropdownMenuSample(
                    title = stringResource(R.string.color_titulo),
                    options = optionsColor,
                    selectedOption = viewModel.colorDelVehiculo.value,
                    onOptionSelected = { viewModel.colorDelVehiculo.value = it },
                    label = { it.displayName }
                )
                DropdownMenuSample(
                    title = stringResource(R.string.uso_vehiculo_titulo),
                    options = optionsUsoVehiculo,
                    selectedOption = viewModel.usoDelVehiculo.value,
                    onOptionSelected = { viewModel.usoDelVehiculo.value = it },
                    label = { it.displayName }
                )

                AppButton(
                    action = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        if (solicitud != null) {
                            crearSolicitudViewModel.datosPropietarioVehiculoAsegurado(solicitud)
                            navController.navigate(route = Rutas.DatosPropietarioVehiculoTercero.ruta)
                        } else {
                            showToastError(context, "error: No se puede crear la solicitud")
                            Log.d("solicitud", "no se creo")
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(R.string.siguiente)
                )
            }
        }
    }
}

