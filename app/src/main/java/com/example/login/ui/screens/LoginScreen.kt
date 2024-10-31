package com.example.login.ui.screens

import android.content.Context
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.data.models.ErrorResponse
import com.example.login.utilities.LastCharVisibleTransformation
import com.example.login.data.network.RetrofitClient
import com.example.login.data.models.UserLogin
import com.example.login.components.Field
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.utilities.showToastError
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

suspend fun handleLogin(user: UserLogin, context: Context, navController: NavController) {
    try {
        val response = RetrofitClient.apiService.login(user)
        Token.token = response.token
        navController.navigate(route = Rutas.HomeScreen.ruta)
    } catch (e: Exception) {
        val errorMessage = when (e) {
            is HttpException -> {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = try {
                    Gson().fromJson(errorBody, ErrorResponse::class.java)
                } catch (jsonException: JsonSyntaxException) {
                    ErrorResponse(errorBody ?: "Error desconocido contactar con el asegurador")
                }
                errorResponse?.error ?: "Error desconocido contactar con el asegurador"
            }
            else -> e.message ?: "Error desconocido contactar con el asegurador"
        }
        showToastError(context, "Error al iniciar sesión, $errorMessage")
    }
}


@Composable
fun LoginScreen(navController: NavController) {
    RegisterText(navController = navController)
}

@Composable
fun RegisterText(modifier: Modifier = Modifier, navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Iniciar Sesion",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(16.dp))
        Field(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            errorMessage = "Formato de email inválido",
            isValid = ::isEmailValid,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.height(16.dp))
        Field(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            errorMessage = "La contraseña debe tener al menos 4 caracteres",
            isValid = { it.length >= 4 },
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            visualTransformation = LastCharVisibleTransformation(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val user = UserLogin(email.text, password.text)
                CoroutineScope(Dispatchers.Main).launch {
                    handleLogin(user, context, navController)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }
    }
}
