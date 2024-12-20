package com.example.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF009B77),
            secondary = Color(red = 230, green = 230, blue = 250),
            //background = Color(red = 230, green = 230, blue = 250),
        ),
        typography = Typography(
            titleLarge = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
            bodyLarge = TextStyle(fontSize = 16.sp)
        ),
        shapes = Shapes(),
    ) {
        Box(modifier = Modifier.safeDrawingPadding()) {
            content()
        }
    }
}
