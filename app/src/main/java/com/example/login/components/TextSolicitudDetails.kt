package com.example.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextSolicitudDetails(label: String, value: String) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(
            text = label, color = Color(
                red = 52,
                green = 52,
                blue = 52,
                alpha = 205
            ),
            modifier = Modifier.padding(end = 2.dp)
        )
        Text(
            value,
            modifier = Modifier
                .padding(start = 4.dp, end = 8.dp)
        )
    }
}