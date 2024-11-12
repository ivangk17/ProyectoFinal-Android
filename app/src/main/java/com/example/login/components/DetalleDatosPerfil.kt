package com.example.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.components.solicituddetails.TextPolicyDetails
import com.example.login.data.network.models.UserInfoResponse

@Composable
fun DetalleDatosPerfil(user: MutableState<UserInfoResponse>) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text("Datos Personales",
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 15.dp, bottom =  12.dp)
            )
            TextPolicyDetails("Nombre Completo:", user.value.nombreCompleto)
            Row {
                //TODO obtener los datos del asegurado
                //TextPolicyDetails("Asegurado:" ,"Nombre del asegurado")
                //TextPolicyDetails("Dni:", poliza.dniAsegurado)
            }
            TextPolicyDetails("Email:", user.value.email)
            TextPolicyDetails("DNI:", "${user.value.dni}")
            TextPolicyDetails("Fecha de nacimiento:", user.value.fechaDeNacimiento)
            TextPolicyDetails("Telefono:", user.value.telefono.toString())
            Text("Datos Domiciliares",
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 15.dp, bottom =  12.dp)
            )
            Row {
                TextPolicyDetails("Direccion:", user.value.domicilio.calle)
                TextPolicyDetails("", user.value.domicilio.numero.toString())
            }
            if(user.value.domicilio.piso != null  || user.value.domicilio.departamento != null) {
                Row {
                    if (user.value.domicilio.piso != null && !user.value.domicilio.piso.toString().isEmpty()){
                        TextPolicyDetails("Piso:", user.value.domicilio.piso.toString())
                    }
                    if (user.value.domicilio.departamento != null && !user.value.domicilio.departamento.toString().isEmpty()){
                        TextPolicyDetails("Departamento", user.value.domicilio.departamento.toString())
                    }
                }
            }
            TextPolicyDetails("Codigo postal:", user.value.domicilio.codigoPostal.toString())

        }
    }
}

