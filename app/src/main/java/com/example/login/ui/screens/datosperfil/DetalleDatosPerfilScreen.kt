package com.example.login.ui.screens.datosperfil

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.login.components.DetalleDatosPerfil
import com.example.login.navigation.Rutas
import com.example.login.ui.viewmodels.DetalleDatosPerfilViewModel

@Composable
fun DetalleDatosPerfilScreen(
    viewModel: DetalleDatosPerfilViewModel,
    navController: NavHostController,
) {
    val user = viewModel.loadInfoUser()

    Column {
        //PolizaDetails(poliza)
        DetalleDatosPerfil(user)
        Button(
            onClick = {
                navController.navigate(Rutas.CambiarDatosPerfil.ruta)
            },
        ) {
            Text("Cambiar mis datos")
        }
    }

}