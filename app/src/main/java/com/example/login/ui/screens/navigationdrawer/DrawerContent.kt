package com.example.login.ui.screens.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp), // Agregar padding superior
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Contenido del drawer", modifier = Modifier.padding(start = 16.dp))

    }
}
