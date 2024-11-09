package com.example.login.components.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.navigation.AppNavigationActions
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel

@Composable
fun NavDrawer2(
    drawerViewModel: DrawerViewModel,
    email: String,
    navigationActions: AppNavigationActions
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        DrawerHeader(email)
        Spacer(modifier = Modifier.height(24.dp))
        DrawerContent2(navigationActions)
    }
}
