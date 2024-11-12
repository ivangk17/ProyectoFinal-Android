package com.example.login.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.components.PolizaCard
import com.example.login.navigation.Rutas
import com.example.login.tokens.Token
import com.example.login.tokens.Utility
import com.example.login.ui.viewmodels.homeviewmodel.HomeUiState
import com.example.login.ui.viewmodels.homeviewmodel.HomeViewModel
import com.google.gson.Gson


val gson = Gson()

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel) {
    val user = Utility().decodeJWT(Token.token)
    val scope = rememberCoroutineScope()
    val polizas by homeViewModel.Polizas
    val uiState by homeViewModel.uiState



    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when (uiState) {
            is HomeUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center) // Centra el indicador de carga en la pantalla
                )
            }
            is HomeUiState.Success -> {
                val polizasList = (uiState as HomeUiState.Success).solicitudes
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(polizasList) { poliza ->
                            PolizaCard(poliza) {
                                val polizaJson = gson.toJson(poliza)
                                navController.navigate("${Rutas.PolizaDetalleScreen.ruta}/$polizaJson")
                            }
                        }
                    }
                }
            }
            is HomeUiState.Empty -> {
                Text(
                    text = (uiState as HomeUiState.Empty).message,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
            is HomeUiState.Error -> {
                Text(
                    text = "Error: ${(uiState as HomeUiState.Error).message}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        }
    }
}