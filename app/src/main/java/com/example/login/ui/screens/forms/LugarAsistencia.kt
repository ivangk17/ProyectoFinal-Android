package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.components.MultipleLine
import com.example.login.components.SwitchCustom
import com.example.login.data.models.solicitud.datosSiniestros.asistencia.EstadoLesiones
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.LugarAsistenciaViewModel
import com.example.login.utilities.showToastError


@Composable
fun LugarAsistencia(
    navController: NavController,
    viewModel: LugarAsistenciaViewModel,
    crearSolicitudViewModel: CrearSolicitudViewModel
) {
    val options = EstadoLesiones.entries
    val context = LocalContext.current
    var huboCentroAsistencia by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        CamposCheckeablesDetails(
            label = "Hubo Centro de Asistencia?",
            campo = huboCentroAsistencia,
            onCheckedChange = { huboCentroAsistencia = it }
        )

        if (huboCentroAsistencia) {
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
                items(viewModel.camposCheckeables.size) { index ->
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
                        label = { it.displayName }
                    )
                    MultipleLine(
                        titulo = "Descripcion de las lesiones",
                        valor = viewModel.descripcionLesiones,
                        onValueChange = { newValue -> viewModel.onDescripcionChange(newValue) },
                        error = viewModel.errorDescripcionLesiones
                    )
                }
            }
        }

        Button(
            onClick = {
                val solicitud = viewModel.crearSolicitudPoliza()
                Log.d("LUGAR", huboCentroAsistencia.toString())
                if (!huboCentroAsistencia) {
                    crearSolicitudViewModel.sinLugarAsistencia(navController)
                } else if (huboCentroAsistencia && solicitud != null) {
                    crearSolicitudViewModel.lugarAsistencia(solicitud, navController)
                } else {
                    showToastError(context, "error: No se puede crear la solicitud")
                    Log.d("solicitud", "no se creo")
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Enviar Solicitud")
        }
    }
}

@Composable
fun CamposCheckeablesDetails(label: String, campo: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label)
        Checkbox(checked = campo, onCheckedChange = onCheckedChange)
    }
}