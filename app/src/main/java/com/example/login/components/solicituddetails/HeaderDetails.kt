package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HeaderDetails(label: String, contenido: @Composable () -> Unit){
    var expanded = remember { mutableStateOf(false) }
    var extraPadding = if(expanded.value) 64.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(horizontal = 1.dp, vertical = 4.dp)
            .fillMaxWidth(1.0F)

    ){
        Box(modifier = Modifier.fillMaxWidth()){

            Column(modifier = Modifier
                .padding(24.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(label, style = TextStyle(fontSize = 20.sp), modifier = Modifier.padding(bottom = 10.dp))
                    }
                    if (!expanded.value) {
                        BotonMostrarMas(expanded)
                    }
                }
                if(expanded.value){
                    contenido()
                }
            }
            if (expanded.value){
                BotonMostrarMas(expanded, Modifier.align(Alignment.BottomEnd).padding(16.dp))
            }
        }

    }
}