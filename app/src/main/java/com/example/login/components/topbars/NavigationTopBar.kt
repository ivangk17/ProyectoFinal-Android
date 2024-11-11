package com.example.login.components.topbars

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.login.R
import kotlinx.coroutines.Job

@Composable
fun NavigationTopBar(
    onClick: () -> Unit,
    quitScreen: () -> Unit,
    topBarColor: Color,
    title: String,
    titleStyle: TextStyle,
    titleColor: Color,
    onMenuClick: () -> Unit
){
    Log.d("NavigationTopBar", "Rendering NavigationTopBar for $title")

    Box(modifier = Modifier
        .background(topBarColor)
        .padding(top = 30.dp, start = 25.dp, end = 25.dp)
        .height(50.dp)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { onClick() }
            )

            Text(
                text = title,
                color = titleColor,
                style = titleStyle,
            )

            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = "Close",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { quitScreen() }
            )
        }

    }
}