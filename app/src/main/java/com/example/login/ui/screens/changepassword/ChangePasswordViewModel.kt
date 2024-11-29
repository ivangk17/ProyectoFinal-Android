package com.example.login.ui.screens.changepassword

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.login.data.models.ErrorResponse
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.network.services.GetServiceUser
import com.example.login.utilities.showToastError
import com.example.login.utilities.showToastSucces
import com.example.login.utilities.validatePassword
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChangePasswordViewModel @Inject constructor(
    private val getServiceUser: GetServiceUser
) : ViewModel() {

    var user = mutableStateOf(UserInfoResponse())

    fun loadInfoUser(): MutableState<UserInfoResponse> {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
        }
        return user
    }

    val campos = listOf(
        FormField("Nueva Contraseña", tipo = TipoCampo.TEXTO, isPassword = true),
        FormField("Confirmar Nueva Contraseña", tipo = TipoCampo.TEXTO, isPassword = true)
    )

    val currentPassword = FormField("Contraseña Actual", tipo = TipoCampo.TEXTO, isPassword = true)

    fun onCampoChange(index: Int, newValue: String) {
        campos[index].value.value = newValue
        campos[index].error.value = null
    }

    fun onCurrentPassChange(newValue: String) {
        currentPassword.value.value = newValue
        currentPassword.error.value = null
    }

    fun handleChangePassword(context: Context,  onPasswordChanged: () -> Unit) {
        validatePassword(campos, currentPassword)

        if (campos.all { it.error.value == null }) {
            viewModelScope.launch {
                try {
                    val response = getServiceUser.changePassword(
                        currentPassword.value.value,
                        campos[0].value.value,
                        campos[1].value.value
                    )
                    if (response.isSuccessful) {
                        showToastSucces(context, "Contraseña cambiada con exito!")
                  onPasswordChanged()  //Agregado
                    } else {
                        val errorBody = response.errorBody()?.string()
                        val apiError = errorBody?.let {
                            try {
                                Gson().fromJson(it, ErrorResponse::class.java)
                            } catch (e: Exception) {
                                ErrorResponse("Error desconocido")
                            }
                        } ?: ErrorResponse("Error desconocido")
                        showToastError(context, "Error al cambiar la contraseña: ${apiError.error}")

                    }
                } catch (e: Exception) {
                    showToastError(context, "Error")
                }
            }
        }
    }


}