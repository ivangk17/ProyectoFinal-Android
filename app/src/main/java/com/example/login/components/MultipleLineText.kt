package com.example.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MultipleLineText(label: String, texto: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(horizontal = 1.dp, vertical = 4.dp)
            .fillMaxWidth(1.0F)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(label, style = TextStyle(fontSize = 20.sp), modifier = Modifier.padding(10.dp))
            Text(
                texto,
                modifier = Modifier.padding(8.dp),
                color = Color(red = 33, green = 33, blue = 33, alpha = 205)
            )
        }

    }
}