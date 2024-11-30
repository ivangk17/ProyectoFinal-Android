package com.example.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
import com.example.login.components.solicituddetails.TextPolicyDetails
import com.example.login.data.models.poliza.Poliza

@Composable
fun PolizaDetails(poliza: Poliza) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box() {
                    Row(modifier = Modifier.padding(bottom = 10.dp)) {
                        Text(
                            text = stringResource(R.string.poliza),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 2.dp),
                            fontSize = 15.sp
                        )
                        Text(
                            poliza._id,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .padding(start = 4.dp, end = 8.dp),
                            fontSize = 15.sp
                        )
                    }
                }
            }
            TextPolicyDetails(stringResource(R.string.aseguradora), poliza.aseguradora)

            TextPolicyDetails(stringResource(R.string.tipo_cobertura), poliza.tipoCobertura)

            Row {
                TextPolicyDetails(stringResource(R.string.prima), "$ ${poliza.primaSegura}")
                TextPolicyDetails(stringResource(R.string.deducible), "$ ${poliza.deducible}")
            }
            Text(
                stringResource(R.string.detalle_bien_asegurado),
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 12.dp)
            )
            TextPolicyDetails(stringResource(R.string.marca), poliza.vehiculo.marca)
            Row {
                TextPolicyDetails(stringResource(R.string.modelo), poliza.vehiculo.modelo)
                TextPolicyDetails(stringResource(R.string.anio), poliza.vehiculo.anio.toString())
            }
            TextPolicyDetails(stringResource(R.string.tipo_vehiculo), poliza.vehiculo.tipoVehiculo)
            TextPolicyDetails(stringResource(R.string.dominio), poliza.vehiculo.dominio)

        }
    }
}
