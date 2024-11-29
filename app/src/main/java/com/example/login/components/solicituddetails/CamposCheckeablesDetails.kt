package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun CamposCheckeablesDetails(label: String, campo: Boolean){

    Row(verticalAlignment = Alignment.CenterVertically){
        Text(
            label
        )
        Checkbox(checked = campo , onCheckedChange = { })
    }
}