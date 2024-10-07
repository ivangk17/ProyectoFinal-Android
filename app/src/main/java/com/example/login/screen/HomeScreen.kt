package com.example.login.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.Api
import com.example.login.Poliza
import com.example.login.tokens.Token
import com.example.login.tokens.Utility
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(navController: NavController) {
    val user = Utility().decodeJWT(Token.token)
    val scope = rememberCoroutineScope()
    var polizas by remember { mutableStateOf<List<Poliza>?>(null) }

    LaunchedEffect(Unit) {
        scope.launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api = retrofit.create(Api::class.java)
            val response = api.getPolizas("Bearer ${Token.token}")

            if (response.isSuccessful) {
                polizas = response.body()
            } else {
                Log.e("HomeScreen", "Error fetching polizas: ${response.errorBody()}")
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (polizas != null) {
            polizas!!.forEach { poliza ->
                Text(
                    text = "Poliza: ${poliza.dominio}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        } else {
            Text(
                text = "Loading polizas...",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}