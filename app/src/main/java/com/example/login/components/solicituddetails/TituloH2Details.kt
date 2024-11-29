package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TituloH2Details(titulo: String){
    Text(titulo, fontSize = 16.sp, modifier = Modifier.padding(bottom = 10.dp, top = 12.dp), textDecoration = TextDecoration.Underline)
}