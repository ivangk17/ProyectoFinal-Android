package com.example.login.components.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.navigation.AppNavigationActions
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavDrawer(
    email: String,
    navigationActions: AppNavigationActions,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(360.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        DrawerHeader(email)
        Spacer(modifier = Modifier.height(24.dp))

        DrawerContent2(navigationActions,drawerState, scope)
    }
}


