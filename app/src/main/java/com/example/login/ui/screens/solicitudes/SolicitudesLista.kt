package com.example.login.ui.screens.solicitudes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.data.models.solicitud.SolicitudSimplificada
import com.example.login.navigation.Rutas

@Composable
fun SolicitudesLista(solicitudes: List<SolicitudSimplificada>, navController: NavHostController) {


    if (solicitudes.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = -100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.Sin_solicitudes),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.texto_Secundario)
            )
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(solicitudes) { solicitud ->
                SolicitudCard(solicitud) {
                    navController.navigate("${Rutas.SolicitudDetalle.ruta}/${solicitud._id}")
                }

            }
        }

    }


}
