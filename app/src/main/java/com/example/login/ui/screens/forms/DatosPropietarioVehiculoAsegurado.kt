package com.example.login.ui.screens.forms

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.vehiculos.UsoDelVehiculo
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoAseguradoViewModel
import com.example.login.ui.viewmodels.forms.DatosPropietarioVehiculoTerceroViewModel

@Composable
fun DatosPropietarioVehiculoAsegurado(
    navController: NavController,
    viewModel: DatosPropietarioVehiculoAseguradoViewModel,
    poliza: Poliza,
    crearSolicitudViewModel: CrearSolicitudViewModel
){
    val options = UsoDelVehiculo.entries //esto devuelve una lista de opciones
    val user = viewModel.loadInfoUser() //TODO NO BORRAR ESTA VARIABLE (porque sino no carga la info del usuario logueado)

//    LaunchedEffect(Unit) {
//        viewModel.loadInfoUser()
//
//    }

    Column (modifier = Modifier.fillMaxSize()){
        LazyColumn (modifier = Modifier.weight(1f)) {
            viewModel.initializeFieldsWithPoliza(poliza)

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
                DropdownMenuSample(
                    title = "Uso del vehiculo",
                    options = options,
                    selectedOption = viewModel.usoDelVehiculo.value,
                    onOptionSelected = { viewModel.usoDelVehiculo.value = it },
                    label = { it.name }
                )

                Button(
                    onClick = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        val polizaJson = gson.toJson(poliza)
                        if (solicitud != null) {
                            crearSolicitudViewModel.datosPropietarioVehiculoAsegurado(solicitud)
                            navController.navigate(route = "${Rutas.DatosPropietarioVehiculoTercero.ruta}/${polizaJson}")
                            Log.d("solicitud", "${solicitud}")
                        } else {
                            Log.d("solicitud", "no se creo")
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Enviar Solicitud")
                }
            }
        }
    }
}

