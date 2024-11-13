package com.example.login.ui.screens

import android.content.Context
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.R
import com.example.login.components.AppButton
import com.example.login.data.models.ErrorResponse
import com.example.login.utilities.LastCharVisibleTransformation
import com.example.login.data.network.RetrofitClient
import com.example.login.data.models.UserLogin
import com.example.login.components.Field
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.ui.viewmodels.mainactivityviewmodel.MainViewModel
import com.example.login.utilities.ContactPhonesList
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

suspend fun handleLogin(
    user: UserLogin,
    context: Context,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    try {
        val response = RetrofitClient.apiService.login(user)
        Token.token = response.token
        mainViewModel.updateEmail()
        navController.navigate(route = Rutas.HomeScreen.ruta) {
            popUpTo(0) { inclusive = true }
        }
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
        showToastError(context, "Error al iniciar sesión $errorMessage")
    }
}


@Composable
fun LoginScreen(navController: NavController, mainViewModel: MainViewModel) {
    RegisterText(navController = navController, mainViewModel = mainViewModel)
}

@Composable
fun RegisterText(
    modifier: Modifier = Modifier,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    var passwordVisible by remember { mutableStateOf(false) }
    var isClicked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.welcome),
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 40.dp),
            color = colorResource(id = R.color.texto_Secundario)
        )




        Spacer(modifier = Modifier.height(65.dp))
        Text(
            text = stringResource(R.string.iniciar_sesion),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp),
            color = colorResource(id = R.color.texto_Secundario)
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
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    val icon = if (passwordVisible) {
                        ImageVector.vectorResource(id = R.drawable.visibility_icon)
                    } else {
                        ImageVector.vectorResource(id = R.drawable.visibility_icon_off)
                    }
                    Icon(
                        imageVector = icon,
                        contentDescription = if (passwordVisible)  stringResource(R.string.hide_password) else stringResource(R.string.show_password),
                        modifier = Modifier.padding(start = 0.dp, bottom = 1.dp, end= 15.dp)
                            .size(25.dp)

                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppButton(
            action = {
                val user = UserLogin(email.text, password.text)
                CoroutineScope(Dispatchers.Main).launch {
                    handleLogin(user, context, navController, mainViewModel)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .height(60.dp),

            text = stringResource(R.string.iniciar_sesion)
        )
        Column {

            Box(modifier = Modifier.padding(top = 10.dp)) {
                BasicText(
                    text = "Recuperar contraseña",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.clickable {
                        isClicked = !isClicked
                        // Acción a realizar cuando se hace clic en el texto
                        navController.navigate(Rutas.RecoverPass.ruta)
                    }
                )
            }

        }

    }
}
