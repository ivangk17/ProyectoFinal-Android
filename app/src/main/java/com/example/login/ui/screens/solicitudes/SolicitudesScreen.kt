package com.example.login.ui.screens.solicitudes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.data.models.solicitud.SolicitudSimplificada
import com.example.login.ui.navigationdrawer.NavDrawer
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudesViewModel
import kotlinx.coroutines.launch


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
                    text = stringResource(R.string.Solicitudes_titulo),
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


    if (solicitudes.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize()
                .offset(y=-100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.Sin_solicitudes), fontSize = 25.sp,fontWeight = FontWeight.Bold, color = colorResource(id = R.color.texto_Secundario))
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

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

                        Text(text = stringResource(R.string.id_solicitud, solicitud.idSolicitud))
                        Text(text = stringResource(R.string.estado, solicitud.estado))
                        Text(
                            text = stringResource(
                                id = R.string.fecha_siniestro,
                                solicitud.fechaOcurrencia
                                    ?: stringResource(id = R.string.dato_no_disponible)
                            )
                        )


                    }
                }
            }
        }

    }


}
