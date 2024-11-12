package com.example.login.components.topbars

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.navigation.Rutas
import kotlinx.coroutines.Job

@Composable
fun NavigationTopBar(
    onClick: () -> Unit,
    quitScreen: Boolean,
    topBarColor: Color,
    title: String,
    titleStyle: TextStyle,
    titleColor: Color,
    navController: NavHostController,
    moveText: Boolean
){
    Box(
        modifier = Modifier
            .background(topBarColor)
            .padding(top = 30.dp, start = 25.dp, end = 25.dp)
            .height(50.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { onClick() }
            )

            if (moveText && !quitScreen) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Text(
                        text = title,
                        color = titleColor,
                        style = titleStyle,
                        fontSize = 19.sp
                    )
                }
            } else {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(
                        text = title,
                        color = titleColor,
                        style = titleStyle,
                    )
                }
                if (quitScreen) {
                    Icon(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { navController.navigate(Rutas.HomeScreen.ruta) }
                    )
                } else {
                    Spacer(modifier = Modifier.size(20.dp))
                }
            }
        }

    }
}