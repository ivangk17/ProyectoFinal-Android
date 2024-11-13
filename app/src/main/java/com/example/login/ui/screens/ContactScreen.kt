package com.example.login.ui.screens

// En el archivo de tus Composables, como MainScreen.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
        modifier = Modifier.padding(end = 16.dp)
    ) {
        contacts.forEach { contact ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(67.dp),

            ) {
                Row(
                    modifier = Modifier
                        .background(color = Color(0xFFDFE6FA))
                        .fillMaxWidth()
                        .padding(16.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = contact.icon),
                        contentDescription = contact.name,
                        modifier = Modifier
                            .size(45.dp)
                            .padding(end = 12.dp)
                    )


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
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
