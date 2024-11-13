package com.example.login.ui.screens

// En el archivo de tus Composables, como MainScreen.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.login.data.models.ContactPhones

@Composable
fun ContactPhonesListView(contacts: List<ContactPhones>) {
    Column(
        modifier = Modifier.padding(16.dp) // Añadir padding alrededor de toda la lista
    ) {
        contacts.forEach { contact ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),

            ) {
                Row(
                    modifier = Modifier
                        .background(color = Color(0xFFDFE6FA))
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically // Alinear el contenido verticalmente al centro
                ) {
                    // Ícono del contacto
                    Icon(
                        painter = painterResource(id = contact.icon),
                        contentDescription = contact.name,
                        modifier = Modifier
                            .size(40.dp) // Tamaño del ícono
                            .padding(end = 8.dp) // Espacio entre el ícono y el texto
                    )

                    // Column para nombre y número
                    Column {
                        Text(
                            text = contact.name,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = contact.phoneNumber,
                            style = MaterialTheme.typography.headlineMedium,

                        )
                    }
                }
            }
        }
    }
}
