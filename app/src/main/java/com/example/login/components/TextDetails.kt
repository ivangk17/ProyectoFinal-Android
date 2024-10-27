package com.example.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp

@Composable
fun TextDetails(label: String, value:String){
    Column {
        Text(label, style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.ExtraLight), color = Color.Gray)
        Box(modifier = Modifier.width(10.dp).fillMaxWidth().background(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)))
        Text(value, style = TextStyle(fontWeight = FontWeight.Light))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextDetails("Asegurado/a", "Aguirre, Juan Pablo")
}