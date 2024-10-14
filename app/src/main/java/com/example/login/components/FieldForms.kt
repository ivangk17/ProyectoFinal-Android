package com.example.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FieldStringForms(
    label: String,
    value: MutableState<String>,
    error: MutableState<String?> = mutableStateOf(null),
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val isError = error.value != null

    Column(modifier = modifier.padding(8.dp)) {
        TextField(
            value = value.value,
            onValueChange = { newValue ->
                onValueChange(newValue)
            },
            label = { Text(label) },
            isError = isError,
            modifier = Modifier.fillMaxWidth()
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