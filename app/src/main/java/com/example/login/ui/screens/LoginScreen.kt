package com.example.login.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
import com.example.login.components.Field
import com.example.login.data.models.UserLogin
import com.example.login.navigation.Rutas
import com.example.login.ui.viewmodels.mainactivityviewmodel.MainActivityViewModel
import com.example.login.utilities.isEmailValid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    mainActivityViewModel: MainActivityViewModel
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
                        contentDescription = if (passwordVisible) stringResource(R.string.hide_password) else stringResource(
                            R.string.show_password
                        ),
                        modifier = Modifier
                            .padding(start = 0.dp, bottom = 1.dp, end = 15.dp)
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
                    mainActivityViewModel.handleLogin(user, context, navController)
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
                    modifier = Modifier
                        .padding(start = 13.dp)
                        .clickable {
                            isClicked = !isClicked

                            navController.navigate(Rutas.RecoverPass.ruta)
                        }
                )
            }

        }

    }
}
