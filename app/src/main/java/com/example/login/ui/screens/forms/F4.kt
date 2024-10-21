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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.components.DatePicker
import com.example.login.components.FieldStringForms
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.viewmodels.forms.F4ViewModel

@Composable
fun F4(navController: NavController, viewModel: F4ViewModel, poliza: Poliza) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        item {
            Text(
                text = "DATOS DEL PROPIETARIO DEL OTRO VEHÍCULO",
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(20.dp)
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
            DatePicker(
                label = "Fecha de vencimiento de la poliza",
                valor = viewModel.FechaVencimiento,
                error = viewModel.errorFechaVencimiento,
                onDateSelected = { newValue -> viewModel.onFechaChange(newValue) }
            )
        }



        item {
            Column {
                Button(
                    onClick = {
                        val solicitud = viewModel.crearSolicitudPoliza()
                        if (solicitud != null) {
                            Log.d("solicitud", "se creo")
                            Log.d("solicitud", "${viewModel.Solicitud} ")
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
