package com.example.login.components.topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R

@Composable
fun TopBar(
    topBarColor: Color,
    title: String,
    titleStyle: TextStyle,
    titleColor: Color,
    description: String = "",
    onMenuClick: (() -> Unit)? = null,
    showMenuIcon: Boolean
) {
    val align = if (description.isNotEmpty()) Alignment.TopStart else Alignment.Center

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 30.dp, start = 25.dp, end = 25.dp, bottom = 50.dp)
            .height(50.dp)
            .fillMaxWidth(),
        contentAlignment = align
    ) {
        if (showMenuIcon) {
            onMenuClick?.let {
                IconButton(
                    onClick = it,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .absoluteOffset(x = (-10).dp)
                ) {
                    Icon(painter = painterResource(
                        id = R.drawable.menu_icon),
                        contentDescription = "Open Drawer",
                        modifier = Modifier.size(38.dp)
                            .padding(start =5.dp))
                }
            }

        }


        Column {
            Text(
                text = title,
                style = titleStyle,
                color = titleColor,
                fontSize = 22.sp
            )
            if (description.isNotEmpty()) {
                Text(
                    text = description,
                    style = TextStyle(fontWeight = FontWeight.Normal),
                    color = MaterialTheme.colorScheme.tertiary,
                )
            }
        }
    }
}
