package com.example.login.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun TimePicker(onTimeSelected: (String) -> Unit) {
    var showTimePicker by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    val selectedTime = remember { mutableStateOf<Date?>(null) }

    LaunchedEffect(selectedTime.value) {
        selectedTime.value?.let {
            textFieldValue = SimpleDateFormat("HH:mm", Locale.getDefault()).format(it)
            onTimeSelected(textFieldValue)
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { newValue ->
                textFieldValue = newValue
                val time = try {
                    SimpleDateFormat("HH:mm", Locale.getDefault()).parse(newValue)
                } catch (e: Exception) {
                    null
                }
                if (time != null) {
                    selectedTime.value = time
                }
            },
            label = { Text("Selecciona la hora de ocurrencia") },
            trailingIcon = {
                IconButton(onClick = { showTimePicker = !showTimePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select time"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showTimePicker) {
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                onTimeSelected = { hour, minute ->
                    calendar.set(Calendar.HOUR_OF_DAY, hour)
                    calendar.set(Calendar.MINUTE, minute)
                    selectedTime.value = calendar.time
                    showTimePicker = false
                }
            )
        }
    }
}