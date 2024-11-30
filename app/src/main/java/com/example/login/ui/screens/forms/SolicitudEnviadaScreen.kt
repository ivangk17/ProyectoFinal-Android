package com.example.login.ui.screens.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.navigation.Rutas
import com.example.login.ui.screens.gson
import kotlinx.coroutines.delay


@Composable
fun SolicitudEnviadaScreen(navController: NavHostController) {
    var ok by remember { mutableStateOf(false) }

    LaunchedEffect(ok) {
        delay(8000)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        if (!ok) {
            Text(
                text = stringResource(R.string.solicitud_enviada),
                style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
            )
            ok = true
        } else {
            navController.navigate(Rutas.HomeScreen.ruta){
                popUpTo(0) { inclusive = true }
            }

        }
    }
}

