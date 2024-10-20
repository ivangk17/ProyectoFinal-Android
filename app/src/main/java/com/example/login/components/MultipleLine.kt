package com.example.login.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MultipleLine(
    titulo: String,
    valor: MutableState<String?>,
    onValueChange: (String) -> Unit,
    error: MutableState<String?> = mutableStateOf(null),
    ){

    if(valor.value.isNullOrEmpty()){
        valor.value = ""
    }

    val isError = error.value != null

    Column {
        Text(
            titulo,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(25.dp)
        )
        TextField(
            label = { Text(titulo) },
            value = valor.value!!,
            onValueChange = { newValue ->
                onValueChange(newValue)
            },
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
        )
        if (isError) {
            Text(
                text = error.value ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}