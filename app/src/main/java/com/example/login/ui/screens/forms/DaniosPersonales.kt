package com.example.login.ui.screens.forms

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.example.login.ui.viewmodels.forms.DaniosPersonalesViewModel

@Composable
fun DaniosPersonales(navController: NavController, viewModel: DaniosPersonalesViewModel, poliza: Poliza){
    val options = Sexo.entries

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        item {
            Text(
                "Daños Personales",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(25.dp)
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
                    label = { it.name }
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
                    val polizaJson = gson.toJson(poliza)
                    //TODO COMPLETAR
                    //navController.navigate("${Rutas.ConsecuenciaSiniestro.ruta}/${polizaJson}")
                    if (solicitud != null) {
                        Log.d("SOLICITUD", viewModel.solicitud.toString())
                    } else {
                        Log.d("solicitud", "no se creo")
                    }
                }
            ) {
                Text("Siguiente")
            }
        }
    }
}