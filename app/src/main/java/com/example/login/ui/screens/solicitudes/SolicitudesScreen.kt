package com.example.login.ui.screens.solicitudes

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.data.models.solicitud.SolicitudSimplificada
import com.example.login.navigation.Rutas
import com.example.login.ui.navigationdrawer.NavDrawer
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudesViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolicitudesScreen(
    viewModel: SolicitudesViewModel,
    navController: NavHostController,
    drawerViewModel: DrawerViewModel
) {
    val solicitudes by viewModel.solicitudes.observeAsState(emptyList())
    val error by viewModel.error.observeAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Muestra el Snackbar cuando hay un error
    error?.let {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = "Error: $it",
                actionLabel = "Cerrar"
            )
        }
    }

    NavDrawer(navController, drawerViewModel) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // Snackbar host

        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Solicitudes",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp),
                    color = colorResource(id = R.color.texto_principal)
                )
                SolicitudesList(solicitudes, navController)
            }
        }
    }
}

@Composable
fun SolicitudesList(solicitudes: List<SolicitudSimplificada>, navController: NavHostController) {

    Log.d("SolicitudesList", "Solicitudes size: ${solicitudes.size}")
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        Log.d("SolicitudesScreen", "Solicitudes size: ${solicitudes.size}")
        items(solicitudes) { solicitud ->
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .clickable {
                       // navController.navigate(Rutas.SolicitudDetalle.rutaConId(solicitud.id))

                    }
            ) {
                Column(modifier = Modifier.padding(8.dp)) {

                    Text(text = "ID de la solicitud: ${solicitud.idSolicitud}")
                    Text(text = "Estado: ${solicitud.estado}")
                    Text(text = "Fecha del siniestro: ${solicitud.fechaOcurrencia ?: "Fecha no disponible"}")
                    Text(text = "Datos del cliente asegurado:", modifier = Modifier.padding(top = 3.dp))
                    Text(text = "ID: ${solicitud.idAsegurado ?: "No disponible"}")
                    Text(text = "Apellido y nombre: ${solicitud.nombreAsegurado}")


                }
            }
        }
    }
}
