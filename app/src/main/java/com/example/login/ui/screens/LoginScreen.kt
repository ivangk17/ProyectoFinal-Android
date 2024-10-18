package com.example.login.ui.screens

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.login.data.models.ErrorResponse
import com.example.login.utilities.LastCharVisibleTransformation
import com.example.login.data.network.RetrofitClient
import com.example.login.data.models.User
import com.example.login.components.Field
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

suspend fun handleLogin(user: User, context: Context, navController: NavController) {
    try {
        val response = RetrofitClient.apiService.login(user)
        Token.token = response.token
        Toast.makeText(context, "Login exitoso, Token: ${response.token}", Toast.LENGTH_SHORT).show()
        navController.navigate(route = Rutas.HomeScreen.ruta)
    } catch (e: Exception) {
        val errorMessage = when (e) {
            is HttpException -> {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = try {
                    Gson().fromJson(errorBody, ErrorResponse::class.java)
                } catch (jsonException: JsonSyntaxException) {
                    ErrorResponse(errorBody ?: "Error desconocido")
                }
                errorResponse?.message ?: "Error desconocido"
            }
            else -> e.message ?: "Error desconocido"
        }
        Log.e("TAG", "Error en la ejection: $errorMessage", e)
        Toast.makeText(context, "Error al hacer login, error: $errorMessage", Toast.LENGTH_SHORT).show()
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
            text = "Register",
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
            label = "Password",
            errorMessage = "La contraseña debe tener al menos 4 caracteres",
            isValid = { it.length >= 4 },
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            visualTransformation = LastCharVisibleTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val user = User(email.text, password.text)
                CoroutineScope(Dispatchers.Main).launch {
                    handleLogin(user, context, navController)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear cuenta")
        }
    }
}
