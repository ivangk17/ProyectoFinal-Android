package com.example.login.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.login.data.models.poliza.Poliza
import com.example.login.ui.screens.forms.F1
import com.example.login.ui.screens.forms.F5
import com.example.login.ui.viewmodels.forms.F1ViewModel
import com.example.login.ui.viewmodels.forms.F5ViewModel

@Composable
fun SolicitidPolizaScreen(poliza: Poliza, viewModel: F1ViewModel, navController: NavController) {
    val context = LocalContext.current
    F1(navController, viewModel, context)
}