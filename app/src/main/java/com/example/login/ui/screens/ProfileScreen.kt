package com.example.login.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.components.profilescreen.LinkItem
import com.example.login.navigation.Rutas
import com.example.login.ui.theme.TituloFormulario
import com.example.login.ui.viewmodels.ProfileViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel,
    navController: NavHostController,
    drawerViewModel: DrawerViewModel
) {

    val user = profileViewModel.loadInfoUser()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "👋 Hola ${user.value.nombreCompleto}",
                style = TituloFormulario,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Cambiar mis datos", isFirst = true)
            LinkItem(
                modifier = Modifier.offset(y = (-5).dp),
                buttonName = "Cambiar contraseña",
                onClick = {
                    navController.navigate(Rutas.ChangePassword.ruta)
                },
                isLast = true
            )
//            LinkItem(modifier = Modifier.offset(y = (-3).dp), buttonName = "Ayuda")
//            LinkItem(modifier = Modifier.offset(y = (-4).dp), buttonName = "Términos y condiciones")


            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(
                modifier = Modifier.offset(y = (-5).dp),
                buttonName = "Cerrar sesión",
                onClick = {
                    navController.navigate(Rutas.LoginScreen.ruta){
                        Log.d("click", "click")
                        popUpTo(0) {inclusive = true}
                    }
                }
            )

            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}