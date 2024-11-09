package com.example.login.ui.screens.solicitudes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.login.components.navigationdrawer.NavDrawer
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
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

