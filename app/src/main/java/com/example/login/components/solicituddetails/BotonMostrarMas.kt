package com.example.login.components.solicituddetails

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BotonMostrarMas(expanded: MutableState<Boolean>, modifier: Modifier = Modifier){

    ElevatedButton(onClick = { expanded.value = !expanded.value }, modifier = modifier) {
        Text(if (expanded.value) "Mostrar menos" else "Mostrar mas")
    }
}