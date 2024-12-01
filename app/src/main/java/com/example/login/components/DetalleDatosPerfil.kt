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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
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
            Text(
                stringResource(R.string.datos_personales),
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 12.dp)
            )
            TextPolicyDetails(stringResource(R.string.nombre_completo), user.value.nombreCompleto)

            TextPolicyDetails(stringResource(R.string.email), user.value.email)
            TextPolicyDetails(stringResource(R.string.dni), "${user.value.dni}")
            TextPolicyDetails(
                stringResource(R.string.fecha_nacimiento),
                user.value.fechaDeNacimiento
            )
            TextPolicyDetails(stringResource(R.string.telefono), user.value.telefono.toString())
            Text(
                stringResource(R.string.domicilio),
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 12.dp)
            )
            Row {
                TextPolicyDetails(stringResource(R.string.direccion), user.value.domicilio.calle)
                TextPolicyDetails("", user.value.domicilio.numero.toString())
            }
            if (user.value.domicilio.piso != null || user.value.domicilio.departamento != null) {
                Row {
                    if (user.value.domicilio.piso != null && !user.value.domicilio.piso.toString()
                            .isEmpty()
                    ) {
                        TextPolicyDetails(
                            stringResource(R.string.piso),
                            user.value.domicilio.piso.toString()
                        )
                    }
                    if (user.value.domicilio.departamento != null && !user.value.domicilio.departamento.toString()
                            .isEmpty()
                    ) {
                        TextPolicyDetails(
                            stringResource(R.string.departamento),
                            user.value.domicilio.departamento.toString()
                        )
                    }
                }
            }
            TextPolicyDetails(
                stringResource(R.string.codigo_postal),
                user.value.domicilio.codigoPostal.toString()
            )

        }
    }
}

