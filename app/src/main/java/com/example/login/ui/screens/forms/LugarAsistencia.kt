package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.components.MultipleLine
import com.example.login.components.SwitchCustom
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.EstadoLesiones
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.LugarAsistenciaViewModel


@Composable
fun LugarAsistencia(
    navController: NavController,
    viewModel: LugarAsistenciaViewModel,
    poliza: Poliza,
    crearSolicitudViewModel: CrearSolicitudViewModel
){
    val options = EstadoLesiones.entries
    //val solicitud = crearSolicitudViewModel.inicializar()

    Column(modifier = Modifier.fillMaxSize()) {
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
                    title = "Seleccione el estado de las lesiones",
                    options = options,
                    selectedOption = viewModel.estadoLesiones.value,
                    onOptionSelected = { viewModel.estadoLesiones.value = it },
                    label = { it.name }
                )
                MultipleLine(
                    titulo = "Descripcion de las lesiones",
                    valor = viewModel.descripcionLesiones,
                    onValueChange = { newValue -> viewModel.onDescripcionChange(newValue) },
                    error = viewModel.errorDescripcionLesiones
                )
            }
        }

        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitudPoliza()
                if (solicitud != null) {
                    Log.d("solicitud", "se creo")
                    Log.d("solicitud", "${viewModel.solicitud.datosSiniestro.lugarAsistencia} ")
                        crearSolicitudViewModel.lugarAsistencia(solicitud)
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