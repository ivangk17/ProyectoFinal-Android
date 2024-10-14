package com.example.login.ui.screens.forms

import android.content.Context
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.login.components.FieldStringForms
import com.example.login.data.models.FormField
import com.example.login.ui.viewmodels.SolicitudPolizaViewModel

@Composable
fun FirstForm(navController: NavController, viewModel: SolicitudPolizaViewModel, context: Context) {
    LazyColumn {
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
            Button(onClick = {
                val solicitud = viewModel.crearSolicitudPoliza()
                if (solicitud != null) {
                    Log.d("solicitud", "se creo")
                    Log.d("solicitud", solicitud.toString())
                }else{
                    Log.d("solicitud", "no se creo")
                }
            }) {
                Text("Enviar Solicitud")
            }
        }
    }
}

fun validarCampoNoVacio(campo: FormField): String? {
    return if (campo.value.value.isEmpty()) "Este campo no puede estar vacío" else null
}
