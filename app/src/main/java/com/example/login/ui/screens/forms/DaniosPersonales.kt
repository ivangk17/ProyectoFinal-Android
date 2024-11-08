package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.components.DatePicker
import com.example.login.components.DropdownMenuSample
import com.example.login.components.FieldStringForms
import com.example.login.components.SwitchCustom
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.poliza.Poliza
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import com.example.login.ui.viewmodels.CrearSolicitudViewModel
import com.example.login.ui.viewmodels.forms.DaniosPersonalesViewModel
import com.example.login.utilities.showToastError

@Composable
fun DaniosPersonales(
    navController: NavController,
    viewModel: DaniosPersonalesViewModel,
    crearSolicitudViewModel: CrearSolicitudViewModel
){
    val options = Sexo.entries
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        items(viewModel.campos.size) { index ->
            val campo = viewModel.campos[index]

            FieldStringForms(
                label = campo.label,
                value = campo.value,
                error = campo.error,
                onValueChange = { newValue -> viewModel.onCampoChange(index, newValue) }
            )

            if(index == 9){
                DatePicker(
                    label = "Fecha de nacimiento",
                    valor = viewModel.fechaNacimiento,
                    error = viewModel.errorFechaNacimiento,
                    onDateSelected = { newValue -> viewModel.onFechaChange(newValue) }
                )
            }else if(index== 10){
                DropdownMenuSample(
                    title = "Sexo",
                    options = options,
                    selectedOption = viewModel.sexoLesionado.value,
                    onOptionSelected = { viewModel.sexoLesionado.value = it },
                    label = { it.displayName }
                )
            }
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
            Button(
                onClick = {
                    val solicitud = viewModel.crearSolicitud()
                    if (solicitud != null) {
                        crearSolicitudViewModel.daniosPersonales(solicitud)
                        navController.navigate(Rutas.LugarAsistencia.ruta)
                    } else {
                        showToastError(context, "error: No se puede crear la solicitud")
                        Log.d("solicitud", "no se creo")
                    }
                }
            ) {
                Text("Siguiente")
            }
        }
    }
}