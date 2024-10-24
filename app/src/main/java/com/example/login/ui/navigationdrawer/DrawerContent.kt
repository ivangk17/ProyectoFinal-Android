package com.example.login.ui.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel

import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerContent(
    drawerViewModel: DrawerViewModel,
    selectedItem: DrawerItems,
    drawerState: DrawerState,
    scope: CoroutineScope,
    onItemSelected: (DrawerItems) -> Unit
) {
    val drawerItems = drawerViewModel.drawerItems

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp), // Agregar padding superior
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Contenido del drawer", modifier = Modifier.padding(start = 16.dp))

    }
}
