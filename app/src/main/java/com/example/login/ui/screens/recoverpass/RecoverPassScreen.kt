package com.example.login.ui.screens.recoverpass

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.login.components.FieldStringForms

@Composable
fun RecoverPassScreen(
    recoverPassViewModel: RecoverPassViewModel
){
    val emailToRecoverField = recoverPassViewModel.emailToRecoverField
    val context = LocalContext.current

    Column {
        FieldStringForms(
            label = emailToRecoverField.label,
            value = emailToRecoverField.value,
            error = emailToRecoverField.error,
            onValueChange = { newValue -> recoverPassViewModel.onCampoChange(newValue) },
            isPassword= emailToRecoverField.isPassword
        )

        Button(
            onClick = {
                recoverPassViewModel.handleRecoverPassword(context)
            }
        ) {
            Text("Recuperar contraseña")
        }
    }

}
