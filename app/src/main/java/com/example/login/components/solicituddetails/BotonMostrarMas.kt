package com.example.login.components.solicituddetails

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.login.R

@Composable
fun BotonMostrarMas(expanded: MutableState<Boolean>, modifier: Modifier = Modifier) {

    ElevatedButton(onClick = { expanded.value = !expanded.value }, modifier = modifier) {
        Text(
            if (expanded.value) stringResource(R.string.mostrar_menos) else stringResource(R.string.mostrar_mas),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}