package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CamposCheckeablesDetails(label: String){
    Row(verticalAlignment = Alignment.CenterVertically){
        Text(
            label
        )
        Checkbox(checked = true, onCheckedChange = { })
    }
}