package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun ConsecuenciaSiniestroDetails(){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Daño parcial"
            )
            Checkbox(checked = true, onCheckedChange = { })
            Text(
                "Robo de rueda"
            )
            Checkbox(checked = true, onCheckedChange = { })
            Text(
                "Robo parcial"
            )
            Checkbox(checked = true, onCheckedChange = { })
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        )  {
            Text(
                "Daño a terceros"
            )
            Checkbox(checked = true, onCheckedChange = { })
            Text(
                "Incendio total"
            )
            Checkbox(checked = true, onCheckedChange = { })
            Text(
                "Otros"
            )
            Checkbox(checked = true, onCheckedChange = { })
        }

    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Destruccion total"
        )
        Checkbox(checked = true, onCheckedChange = { })
        Text(
            "Robo/Hurto total"
        )
        Checkbox(checked = true, onCheckedChange = { })
        Text(
            "Rotura de cristales"
        )
        Checkbox(checked = true, onCheckedChange = { })
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Incendio parcial"
        )
        Checkbox(checked = true, onCheckedChange = { })
    }
}