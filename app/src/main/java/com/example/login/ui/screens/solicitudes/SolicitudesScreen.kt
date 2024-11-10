package com.example.login.ui.screens.solicitudes

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.login.ui.viewmodels.solicitudesviewmod.SolicitudesViewModel
import kotlinx.coroutines.launch


@Composable
fun SolicitudesScreen(
    viewModel: SolicitudesViewModel,
    navController: NavHostController
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

    SolicitudesLista(solicitudes, navController)
}

