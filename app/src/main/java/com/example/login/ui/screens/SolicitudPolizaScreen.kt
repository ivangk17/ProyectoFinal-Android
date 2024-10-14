package com.example.login.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.screens.forms.FirstForm
import com.example.login.ui.viewmodels.SolicitudPolizaViewModel

@Composable
fun SolicitidPolizaScreen(poliza: Poliza, viewModel: SolicitudPolizaViewModel, navController: NavController) {
    val context = LocalContext.current
    FirstForm(navController, viewModel, context)
}