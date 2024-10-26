package com.example.login.ui.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.R
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    drawerViewModel: DrawerViewModel,
    navController: NavHostController,
    selectedItem: DrawerItems,
    drawerState: DrawerState,
    scope: CoroutineScope,
    onItemSelected: (DrawerItems) -> Unit


) {
    val drawerItems = drawerViewModel.drawerItems

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp), // Agregar padding superior
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        drawerItems.forEach { item ->
            NavigationDrawerItem(
                label = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = item.userIcon, contentDescription = item.text)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = item.text)
                    }
                },
                selected = item == selectedItem,
                onClick = {
                    onItemSelected(item)
                    scope.launch { drawerState.close() }
                },
                modifier = Modifier.padding(horizontal = 10.dp),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(
                containerColor  = colorResource(id = R.color.blue_1),
                contentColor = MaterialTheme.colorScheme.onPrimary // Asegura que el texto sea legible
            ),
            modifier = Modifier
                .padding(start = 10.dp)
                .width(150.dp)
                .height(40.dp)

        ) {
            Text(text = "Cerrar Sesión")
        }

        Spacer(modifier = Modifier.weight(0.02f))



    }
}
