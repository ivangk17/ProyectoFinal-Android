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
import androidx.navigation.NavHostController
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
            Text("La solicitud fue enviada correctamente")
            ok = true
        } else {
            navController.navigate(Rutas.HomeScreen.ruta){
                popUpTo(0) { inclusive = true }
            }

/*            navController.navigate("${nextRoute}/${gson.toJson(poliza)}"){
                popUpTo("${Rutas.LoadingScreen.ruta}/{polizaJson}/{nextRoute}") { inclusive = true }
            }*/
        }
    }
}

