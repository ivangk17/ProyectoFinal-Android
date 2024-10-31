package com.example.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.login.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePicker(label: String, valor: MutableState<String?>, error: MutableState<String?>, onTimeSelected: (String) -> Unit) {
    var showTimePicker by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val selectedTime = remember { mutableStateOf<Date?>(null) }
    val timeFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())

    LaunchedEffect(selectedTime.value) {
        selectedTime.value?.let {
            val formattedTime = timeFormatter.format(it)
            onTimeSelected(formattedTime)
            showTimePicker = false
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        val shapeClockIcon = RoundedCornerShape(25.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            OutlinedTextField(
                value = valor.value ?: "",
                onValueChange = { },
                label = { Text(label) },
                readOnly = true,
                modifier = Modifier
                    .height(64.dp),
                isError = error.value != null,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Gray,
                    errorContainerColor = Color.Red.copy(alpha = 0.1f),
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = Color.Gray
                )
            )
                IconButton(onClick = { showTimePicker = !showTimePicker }) {
                    Icon(
                        modifier = Modifier.padding(start = 8.dp)
                            .background(MaterialTheme.colorScheme.secondary, shape = shapeClockIcon)
                            .border(width = 1.dp, color = Color.Black, shape = shapeClockIcon),
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Select time"
                    )
                }
        }

        if (error.value != null) {
            Text(
                text = error.value ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        if (showTimePicker) {
            Popup(
                onDismissRequest = { showTimePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    TimePickerDialog(
                        onDismissRequest = { showTimePicker = false },
                        onTimeSelected = { hour, minute ->
                            calendar.set(Calendar.HOUR_OF_DAY, hour)
                            calendar.set(Calendar.MINUTE, minute)
                            selectedTime.value = calendar.time
                            valor.value = timeFormatter.format(calendar.time)
                        }
                    )
                }
            }
        }
    }
}
