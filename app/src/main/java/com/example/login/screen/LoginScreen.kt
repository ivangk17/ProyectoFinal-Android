package com.example.login.screen

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.navigation.navArgument
import com.example.login.ErrorResponse
import com.example.login.LastCharVisibleTransformation
import com.example.login.LoginResponse
import com.example.login.RetrofitClient
import com.example.login.User
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.ui.theme.LoginTheme
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
        navController.navigate(route = Rutas.homeScreen)
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
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
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
            fontSize = 36.sp, // Tamaño de texto grande
            fontWeight = FontWeight.Bold, // Texto en negrita
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = email, onValueChange = { email = it
            emailError = !isEmailValid(it.text)
        }, label = { Text("Email") },
            isError = emailError,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ), modifier = Modifier.fillMaxWidth())
        if (emailError) {
            Text(
                "Formato de email inválido",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = it.text.length < 4 },
            label = { Text("Password") },
            visualTransformation = LastCharVisibleTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (passwordError) {
            Text(
                text = "La contraseña debe tener al menos 4 caracteres",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val user = User(email.text, password.text)
                CoroutineScope(Dispatchers.Main).launch {
                    handleLogin(user, context, navController = navController)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear cuenta")
        }
    }
}
