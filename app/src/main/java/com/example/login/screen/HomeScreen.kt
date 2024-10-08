import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.login.components.PolizaCard
import com.example.login.data.models.Poliza
import com.example.login.data.network.RetrofitClient
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
                    Log.e("HomeScreen", "Error fetching polizas: ${response.errorBody()?.string()}")
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


