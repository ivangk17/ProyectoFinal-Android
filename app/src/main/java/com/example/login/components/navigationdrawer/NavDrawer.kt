package com.example.login.components.navigationdrawer

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModelFactory
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavDrawer(

    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
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


