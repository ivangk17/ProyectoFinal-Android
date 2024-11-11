package com.example.login.components

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.components.solicituddetails.TextPolicyDetails
import com.example.login.components.solicituddetails.TituloH2Details
import com.example.login.components.solicituddetails.VehiculosDetails
import com.example.login.data.models.poliza.Poliza
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.models.vehiculos.Vehiculo

@Composable
fun PolizaDetails(poliza: Poliza){
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
                    Text("Detalle de la Poliza",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 26.dp, bottom =  12.dp)
                    )
                    Row(modifier =  Modifier.padding(bottom = 10.dp)) {
                        Text(text = "Poliza:",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 2.dp),
                            fontSize = 10.sp
                        )
                        Text(poliza._id,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .padding(end = 8.dp),
                            fontSize = 10.sp
                        )
                    }
                }
            }
            TextPolicyDetails("Aseguradora:", poliza.aseguradora)
            Row {
                //TODO obtener los datos del asegurado
                //TextPolicyDetails("Asegurado:" ,"Nombre del asegurado")
                //TextPolicyDetails("Dni:", poliza.dniAsegurado)
            }
            TextPolicyDetails("Tipo de cobertura:", poliza.tipoCobertura)

            Row {
                TextPolicyDetails("Prima:", "$ ${poliza.primaSegura}")
                TextPolicyDetails("Deducible:", "$ ${poliza.deducible}")
            }
            Text("Detalle del Bien Asegurado",
                fontSize = 17.sp,
                modifier = Modifier.padding(top = 15.dp, bottom =  12.dp)
            )
            TextPolicyDetails("Marca:", poliza.vehiculo.marca)
            Row {
                TextPolicyDetails("Modelo:", poliza.vehiculo.modelo)
                TextPolicyDetails("Año:", poliza.vehiculo.anio.toString())
            }
            TextPolicyDetails("Tipo del Vehiculo:", poliza.vehiculo.tipoVehiculo)
            TextPolicyDetails("Dominio:", poliza.vehiculo.dominio)

        }
    }
}
