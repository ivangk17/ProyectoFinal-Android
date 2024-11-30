package com.example.login.ui.screens.recoverpass

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.login.components.AppButton
import com.example.login.components.FieldStringForms

@Composable
fun RecoverPassScreen(
    recoverPassViewModel: RecoverPassViewModel
) {
    val emailToRecoverField = recoverPassViewModel.emailToRecoverField
    val context = LocalContext.current

    Column {
        FieldStringForms(
            label = emailToRecoverField.label,
            value = emailToRecoverField.value,
            error = emailToRecoverField.error,
            onValueChange = { newValue -> recoverPassViewModel.onCampoChange(newValue) },
            isPassword = emailToRecoverField.isPassword
        )

        AppButton(
            action = {
                recoverPassViewModel.handleRecoverPassword(context)
            },
            modifier = Modifier.padding(start = 4.dp),
            text = "Recuperar contraseña"
        )
    }
}
