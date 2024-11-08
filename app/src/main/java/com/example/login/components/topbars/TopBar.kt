package com.example.login.components.topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    topBarColor: Color,
    title: String,
    titleStyle: TextStyle,
    titleColor: Color,
    description: String = ""
){
    val align = if (description.isNotEmpty()) Alignment.TopStart else Alignment.Center

    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(top = 30.dp, start = 25.dp, end = 25.dp)
        .height(50.dp)
        .fillMaxWidth(),
        contentAlignment = align
    ){
        Column {
            Text(
                text = title,
                style = titleStyle,
                color = Color.Black
            )
            if (description.isNotEmpty()){
                Text(
                    text = description,
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }
        }
    }
}