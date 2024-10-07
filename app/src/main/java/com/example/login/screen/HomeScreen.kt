import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.example.login.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.Poliza
import com.example.login.RetrofitClient
import com.example.login.tokens.Token
import com.example.login.tokens.Utility
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    val user = Utility().decodeJWT(Token.token)
    val scope = rememberCoroutineScope()
    var polizas by remember { mutableStateOf<List<Poliza>?>(null) }

    LaunchedEffect(Unit) {
        scope.launch {
            val response = RetrofitClient.apiService.getPolizas("Bearer ${Token.token}")
            if (response.isSuccessful) {
                polizas = response.body()
            } else {
                // Manejo de error
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (polizas != null) {
            // Recorremos las pólizas y mostramos cada una en una tarjeta
            polizas!!.forEach { poliza ->
                PolizaCard(poliza)
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

@Composable
fun PolizaCard(poliza: Poliza) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Aquí debes colocar el ícono del vehículo, según corresponda
            Image(
                painter = painterResource(id = getVehicleIcon(poliza.dominio)), // Esto es un ejemplo, ajusta según tu recurso
                contentDescription = "Vehicle Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 16.dp)
            )

            Column {
                Text(
                    text = "${poliza.dominio} - ${"poliza.marca"} ${"poliza.modelo"}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Patente: ${poliza.dominio}",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

// Función auxiliar para obtener el ícono correspondiente al vehículo
@Composable
fun getVehicleIcon(dominio: String): Int {
    return if (dominio.contains("Camion", ignoreCase = true)) {
        R.drawable.ic_camion // El ícono del camión
    } else {
        R.drawable.ic_auto // El ícono del auto
    }
}
