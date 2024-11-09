package com.example.login.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.login.R

@Composable
fun LogOutButton(action: () -> Unit) {
    Button(
        onClick = { action() },
        colors = ButtonDefaults.buttonColors(
            containerColor  = colorResource(id = R.color.header_footer),
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        modifier = Modifier
            .padding(start = 10.dp)
            .width(165.dp)
            .height(55.dp)

    ) {
        Text(text = "Cerrar Sesión", textAlign = TextAlign.Center, modifier = Modifier.padding(bottom = 7.dp))
    }

}