package com.example.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.data.models.ContactPhones
import com.example.login.ui.screens.ContactPhonesListView


@Composable
fun EmergencyPhoneIcon(emergencyContacts: List<ContactPhones>) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                painter = painterResource(id = R.drawable.phone_icon), // Usa el ícono correcto
                contentDescription = "Contactos de emergencia",
                Modifier.size(200.dp)

            )
        }

        // Muestra la lista de contactos solo si está expandida
        if (expanded) {
            ContactPhonesListView(contacts = emergencyContacts)
        }
    }
}










/*





IconButton(onClick = { expanded = !expanded }) {
    Icon(
        painter = painterResource(R.drawable.phone_icon), // Usa el icono de teléfono aquí
        contentDescription = "Contactos de emergencia"
    )
}


 */