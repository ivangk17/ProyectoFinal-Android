package com.example.login.ui.screens.recoverpass

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.ErrorResponse
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.network.services.GetServiceUser
import com.example.login.utilities.showToastError
import com.example.login.utilities.showToastSucces
import com.example.login.utilities.validarMail
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecoverPassViewModel @Inject constructor(
    private val getServiceUser: GetServiceUser,
) : ViewModel() {

    val emailToRecoverField = FormField("Email de la cuenta", tipo = TipoCampo.TEXTO)

    fun onCampoChange(newValue: String) {
        emailToRecoverField.value.value = newValue
        emailToRecoverField.error.value = null
    }

    fun handleRecoverPassword(context: Context) {
        validarMail(emailToRecoverField)

        if (emailToRecoverField.error.value == null) {
            viewModelScope.launch {
                try {
                    val response = getServiceUser.recoverPassword(emailToRecoverField.value.value)

                    if (response.isSuccessful) {
                        showToastSucces(context, "Revisa tu correo electronico")
                    } else {
                        val errorBody = response.errorBody()?.string()
                        val apiError = errorBody?.let {
                            try {
                                Gson().fromJson(it, ErrorResponse::class.java)
                            } catch (e: Exception) {
                                ErrorResponse("Error desconocido")
                            }
                        } ?: ErrorResponse("Error desconocido")

                        showToastError(context, "Error: ${apiError.error}")
                    }

                } catch (e: Exception) {
                    showToastError(context, "Error")
                }
            }
        }
    }
}


