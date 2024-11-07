package com.example.login.ui.screens.forms

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
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
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.poliza.Poliza
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
){
    val context = LocalContext.current
    val optionsUsoVehiculo = UsoDelVehiculo.entries //esto devuelve una lista de opciones
    val optionsSexo = Sexo.entries
    val user = viewModel.loadInfoUser(polizaParametro) //TODO NO BORRAR ESTA VARIABLE (porque sino no carga la info del usuario logueado)

//    LaunchedEffect(Unit) {
//        viewModel.loadInfoUser()
//
//    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ){
        LazyColumn (modifier = Modifier.weight(1f)) {

            items(viewModel.campos.size) { index ->
                val campo = viewModel.campos[index]

                FieldStringForms(
                    label = campo.label,
                    value = campo.value,
                    error = campo.error,
                    onValueChange = { newValue -> viewModel.onCampoChange(index, newValue) }
                    )

                if(index == 8){
                    DropdownMenuSample(
                        title = "Sexo",
                        options = optionsSexo,
                        selectedOption = viewModel.sexoSeleccionado.value,
                        onOptionSelected = { viewModel.sexoSeleccionado.value = it },
                        label = { it.displayName }
                    )
                }
                }

            item {
                DropdownMenuSample(
                    title = "Uso del vehiculo",
                    options = optionsUsoVehiculo,
                    selectedOption = viewModel.usoDelVehiculo.value,
                    onOptionSelected = { viewModel.usoDelVehiculo.value = it },
                    label = { it.displayName }
                )

                Button(
                    onClick = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        val polizaJson = gson.toJson(polizaParametro)
                        if (solicitud != null) {
                            crearSolicitudViewModel.datosPropietarioVehiculoAsegurado(solicitud)
                            navController.navigate(route = "${Rutas.DatosPropietarioVehiculoTercero.ruta}/${polizaJson}")
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

