package com.example.login.ui.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

    }
}
