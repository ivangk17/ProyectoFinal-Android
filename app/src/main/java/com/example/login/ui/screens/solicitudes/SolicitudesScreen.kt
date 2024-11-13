package com.example.login.ui.screens.solicitudes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudesUiState
import com.example.login.ui.viewmodels.solicitudesviewmodel.SolicitudesViewModel


@Composable
fun SolicitudesScreen(
    viewModel: SolicitudesViewModel,
    navController: NavHostController
) {
    val uiState by viewModel.uiState
    val snackbarHostState = remember { SnackbarHostState() }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 17.dp)
    ) {
        when (uiState) {
            is SolicitudesUiState.Loading -> {

                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is SolicitudesUiState.Success -> {
                val solicitudes = (uiState as SolicitudesUiState.Success).solicitudes
                SolicitudesLista(solicitudes = solicitudes, navController = navController)
            }

            is SolicitudesUiState.Empty -> {
                val message = (uiState as SolicitudesUiState.Empty).message
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = -100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = message,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.texto_Secundario)
                    )
                }
            }

            is SolicitudesUiState.Error -> {
                val message = (uiState as SolicitudesUiState.Error).message
                LaunchedEffect(snackbarHostState) {
                    snackbarHostState.showSnackbar(
                        message = "Error: $message",
                        actionLabel = "Cerrar"
                    )
                }
            }
        }
    }
}

