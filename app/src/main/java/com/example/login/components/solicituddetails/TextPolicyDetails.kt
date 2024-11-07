package com.example.login.components.solicituddetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextPolicyDetails(label: String, value: String){
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 2.dp),
            fontSize = 14.sp
        )
        Text(value,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(end = 8.dp),
            fontSize = 14.sp
        )
    }
}

