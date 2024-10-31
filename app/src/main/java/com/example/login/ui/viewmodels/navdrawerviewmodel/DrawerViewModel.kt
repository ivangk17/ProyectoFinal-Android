package com.example.login.ui.viewmodels.navdrawerviewmodel


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.lifecycle.ViewModel
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.tokens.Utility
import com.example.login.ui.navigationdrawer.DrawerItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class DrawerViewModel(): ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    fun updateEmail() {
        val user = Utility().decodeJWT(Token.token)
        _email.value = user.email
    }


    val drawerItems = listOf(
        DrawerItems(
            userIcon = Icons.Default.Home,
            text = "Home",
            route = Rutas.HomeScreen.ruta
        ),
        DrawerItems(
            userIcon = Icons.Default.Info,
            text = "Solicitudes",
            route = Rutas.SolicitudesScreen.ruta
        )
    )

    val loginRoute = Rutas.LoginScreen.ruta

}