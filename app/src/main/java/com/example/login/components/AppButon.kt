package com.example.login.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    action: () -> Unit
) {
    Button(
        onClick = { action() },

        modifier = modifier
            .padding(7.dp)

    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(1.dp),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }

}