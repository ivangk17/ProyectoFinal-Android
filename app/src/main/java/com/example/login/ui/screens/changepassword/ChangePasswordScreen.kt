package com.example.login.ui.screens.changepassword

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.login.components.AppButton
import com.example.login.components.FieldStringForms
import com.example.login.navigation.Rutas

@SuppressLint("SuspiciousIndentation")
@Composable
fun ChangePasswordScreen(
    changePasswordViewModel: ChangePasswordViewModel
) {
    val currentPassword = changePasswordViewModel.currentPassword
    val context = LocalContext.current

        LaunchedEffect(Unit) {
            changePasswordViewModel.loadInfoUser()
        }

    LazyColumn {

        items(changePasswordViewModel.campos.size) { index ->
            val campo = changePasswordViewModel.campos[index]

            FieldStringForms(
                label = campo.label,
                value = campo.value,
                error = campo.error,
                onValueChange = { newValue -> changePasswordViewModel.onCampoChange(index, newValue) },
                isPassword= campo.isPassword
            )

        }

        item {
            FieldStringForms(
                label = currentPassword.label,
                value = currentPassword.value,
                error = currentPassword.error,
                onValueChange = { newValue -> changePasswordViewModel.onCurrentPassChange(newValue) },
                isPassword= currentPassword.isPassword
            )
        }

        item {
            AppButton(
                action = {
                    changePasswordViewModel.handleChangePassword(context)
            },
                text = "Cambiar contraseña"
            )
        }
    }
}