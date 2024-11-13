package com.example.login.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.login.data.models.ErrorResponse
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.network.models.UserInfoResponse
import com.example.login.data.network.services.GetServiceUser
import com.example.login.utilities.ValidacionesCampos.validarCampos
import com.example.login.utilities.showToastError
import com.google.gson.Gson
import kotlinx.coroutines.launch

class CambiarDatosPerfilViewModel(
    private val getServiceUser: GetServiceUser
): ViewModel() {

    var user = mutableStateOf(UserInfoResponse())

    fun loadInfoUser(): MutableState<UserInfoResponse> {
        viewModelScope.launch {
            user.value = getServiceUser.execute()
            initializeFields(user)
        }
        return  user
    }


    val campos = listOf(
        FormField("Telefono", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Numero", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.TEXTO),
    )

    fun onCampoChange(index: Int, newValue: String){
        campos[index].value.value = newValue
        campos[index].error.value = null
    }

    fun initializeFields(user: MutableState<UserInfoResponse>) {
        campos[0].value.value = user.value.telefono.toString()
        campos[1].value.value = user.value.domicilio.calle
        campos[2].value.value = user.value.domicilio.numero.toString()

        if(user.value.domicilio.piso != null){
            campos[3].value.value = user.value.domicilio.piso.toString()
        }else{
            campos[3].value.value = ""
        }

        if (user.value.domicilio.departamento != null) {
            campos[4].value.value = user.value.domicilio.departamento.toString()
        }else{
            campos[4].value.value = ""
        }

        campos[5].value.value = user.value.domicilio.codigoPostal.toString()
    }

    suspend fun editarPerfil(context: Context): Boolean {
        validarCampos(campos)
        if (campos.all { it.error.value == null }) {
            return try {
                val response = getServiceUser.editarPerfil(
                    phone = campos[0].value.value,
                    address = campos[1].value.value,
                    zip_code = campos[5].value.value.toString(),
                    number = campos[2].value.value.toString(),
                    apartment = if (campos[4].value.value.isEmpty()) "" else campos[4].value.value,
                    floor = if (campos[3].value.value.isEmpty()) "" else campos[3].value.value
                )
                if (response.isSuccessful) {
                    Log.d("Perfil", "ok")
                    true
                } else {
                    val errorBody = response.errorBody()?.string()
                    val apiError = errorBody?.let {
                        try {
                            Gson().fromJson(it, ErrorResponse::class.java)
                        } catch (e: Exception) {
                            ErrorResponse("Error desconocido")
                        }
                    } ?: ErrorResponse("Error desconocido")
                    showToastError(context, "Error al cambiar los datos: ${apiError.error}")
                    Log.d("Perfil", apiError.error)
                    false
                }
            } catch (e: Exception) {
                Log.d("Perfil", e.message.toString())
                showToastError(context, "Error al cambiar los datos: ${e.message}")
                false
            }
        }
        return false
    }






    companion object{
        fun provideFactory(getServiceUser: GetServiceUser): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CambiarDatosPerfilViewModel(getServiceUser) as T
            }
        }
    }
}