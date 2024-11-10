package com.example.login.components.navigationdrawer

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavDrawer(

    // drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    content: @Composable () -> Unit
) {
    /*
    val scope = rememberCoroutineScope()
    val viewModel: DrawerViewModel = viewModel(factory = DrawerViewModelFactory())
    var selectedItem by remember { mutableStateOf(viewModel.drawerItems[0]) }
    val email by viewModel.email.collectAsState()
    //viewModel.updateEmail()
    //  DrawerHeader(email = viewModel.email.value)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            drawerHeader,
            DrawerContent2(),

        }
    ) */
}

          /*

                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open() }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu icon")
                            }
                        }

           */


