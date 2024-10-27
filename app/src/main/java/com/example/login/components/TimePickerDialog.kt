package com.example.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import java.util.Calendar


@Composable
fun TimePickerDialog(
    onDismissRequest: () -> Unit,
    onTimeSelected: (Int, Int) -> Unit
) {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 8.dp,
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Selecciona la hora", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                AndroidView(
                    factory = { context ->
                        android.widget.TimePicker(context).apply {
                            setIs24HourView(true)
                            setOnTimeChangedListener { _, selectedHour, selectedMinute ->
                                onTimeSelected(selectedHour, selectedMinute)
                            }
                        }
                    },
                    update = { view ->
                        view.hour = hour
                        view.minute = minute
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onDismissRequest) {
                    Text("Cerrar")
                }
            }
        }
    }
}