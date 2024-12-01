package com.example.login.ui.screens.forms

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import com.example.login.components.DatePicker
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.navigation.Rutas
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.utilities.showToastError

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatosPropietarioVehiculoTercero(
    navController: NavController,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val context = LocalContext.current
    val optionsSexo = Sexo.entries
    val optionsColor = ColorVehiculo.entries
    val optionsTipoVehiculo = TipoVehiculo.entries
    val formState = crearSolicitudViewModel.propTerceroFormState

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        items(formState.campos.size) { index ->
            val campo = formState.campos[index]
            FieldStringForms(
                label = campo.label,
                value = campo.value,
                error = campo.error,
                onValueChange = { newValue -> crearSolicitudViewModel.onCampoChangePropTercero(formState, index, newValue) }
            )
            if(index == 7){
                DatePicker(
                    label = stringResource(R.string.fecha_nacimiento_titulo),
                    valor = formState.fechaNacimiento,
                    error = formState.errorFechaNacimiento,
                    onDateSelected = { newValue -> crearSolicitudViewModel.setFechaNacimientoPropTercero(formState,newValue) }
                )
                DropdownMenuSample(
                    title = "Sexo",
                    options = optionsSexo,
                    selectedOption = formState.sexoSeleccionado.value,
                    onOptionSelected = { crearSolicitudViewModel.setSexoPropTercero(formState, it )},
                    label = { it.displayName }
                )
            }
            if (index == 9){
                DropdownMenuSample(
                    title = stringResource(R.string.tipo_vehiculo_titulo),
                    options = optionsTipoVehiculo,
                    selectedOption = formState.tipoVehiculo.value,
                    onOptionSelected = {  crearSolicitudViewModel.setTipoVehiculoTercero(formState, it ) },
                    label = { it.displayName }
                )
                DropdownMenuSample(
                    title = stringResource(R.string.color_titulo),
                    options = optionsColor,
                    selectedOption = formState.colorDelVehiculo.value,
                    onOptionSelected = {  crearSolicitudViewModel.setColorVehiculoTercero(formState, it ) },
                    label = { it.displayName }
                )
            }
        }

        item {
            DatePicker(
                label = stringResource(R.string.vencimiento_poliza),
                valor = formState.fechaDeVencimiento,
                error = formState.errorFechaVencimiento,
                onDateSelected = { newValue -> crearSolicitudViewModel.setFechaDeVencimientoPropTercero(formState,newValue) }
            )
        }



        item {
            Column {
                AppButton(
                    action = {
                        val solicitud = crearSolicitudViewModel.crearSolicitudPolizaPropTercero(formState)
                        Log.d("solicitud sera nula o no", solicitud.toString())
                        if (solicitud != null) {
                            crearSolicitudViewModel.datosPropietarioVehiculoTercero(solicitud)
                            navController.navigate(route = Rutas.ConductorVehiculoAsegurado.ruta)
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
