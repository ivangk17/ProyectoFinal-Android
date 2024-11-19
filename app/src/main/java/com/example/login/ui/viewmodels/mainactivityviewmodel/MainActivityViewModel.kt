package com.example.login.ui.viewmodels.mainactivityviewmodel


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.login.data.models.UserLogin
import com.example.login.data.network.services.LoginService
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.tokens.Utility
import com.example.login.utilities.showToastError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainActivityViewModel(private val loginService: LoginService) : ViewModel() {


    private val _drawerShouldBeOpened = MutableStateFlow(false)
    val drawerShouldBeOpened = _drawerShouldBeOpened.asStateFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
 //   val user = Utility().decodeJWT(Token.token)
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    suspend fun handleLogin(
        user: UserLogin,
        context: Context,
        navController: NavController
    ) {
        try {
            val token = loginService.login(user) // Llamar al servicio de login
            Token.token = token
            updateEmail() // Aquí podrías actualizar cualquier dato necesario
            navController.navigate(route = Rutas.HomeScreen.ruta) {
                popUpTo(0) { inclusive = true }
            }
        } catch (e: Exception) {
            val errorMessage = e.message ?: "Error desconocido contactar con el asegurador"
            showToastError(context, "Error al iniciar sesión: $errorMessage")
        }
    }


    /*

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    fun updateEmail() {
        val user = Utility().decodeJWT(Token.token)
        _email.value = user.email
    }

     */
    /*
    fun onUserLoggedIn(token: String) {
        Token.token = token
        updateEmail()
    }
*/

    fun updateEmail() {
        if(Token.token.isNotEmpty()){
            val user = Utility().decodeJWT(Token.token)
            _email.value = user.email
        }

    }



    fun openDrawer() {
        _drawerShouldBeOpened.value = true
    }

    fun resetOpenDrawerAction() {
        _drawerShouldBeOpened.value = false
    }




  //  val loginRoute = Rutas.LoginScreen.ruta

}
//  route = Rutas.HomeScreen.ruta
//     route = Rutas.SolicitudesScreen.ruta