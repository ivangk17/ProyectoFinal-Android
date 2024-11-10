package com.example.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.login.R

@Composable
fun CardDivider() {

    HorizontalDivider(
        color = colorResource(R.color.teal_700),
        modifier = Modifier.fillMaxWidth()
    )
}