package com.example.login.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login.components.MyAppTheme
import com.example.login.components.topbars.NavigationTopBar
import com.example.login.components.topbars.TopBar
import com.example.login.navigation.AppNavigation
import com.example.login.navigation.AppNavigationActions
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModelFactory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerViewModel: DrawerViewModel = viewModel(factory = DrawerViewModelFactory())
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = Closed)
    val drawerOpen by drawerViewModel.drawerShouldBeOpened.collectAsStateWithLifecycle()

//    val currentSelectedScreen by navController.currentScreenAsState(viewModel)


    if (drawerOpen) {
        LaunchedEffect(Unit) {
            try {
                drawerState.open()
            } finally {
                drawerViewModel.resetOpenDrawerAction()
            }
        }
    }

    if (drawerState.isOpen) {
        BackHandler {
            scope.launch {
                drawerViewModel.resetOpenDrawerAction()
            }
        }
    }


    MyAppTheme {

        var lastScreen: String? = ""
        val navigationActions = AppNavigationActions(navController)

        Scaffold(
            topBar = {
                val currentLocation =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                if (!navigationActions.hideTopBar(currentLocation)) {
                    if (navigationActions.getNavigationTopBar(currentLocation)) {
                        NavigationTopBar(
                            onClick = { navController.popBackStack() },
                            quitScreen = { navController.navigate(lastScreen.toString()) },
                            topBarColor = navigationActions.getColorTopBar(currentLocation),
                            title = navigationActions.getTextTopBar(currentLocation),
                            titleStyle = navigationActions.getTitleStyleTopBar(currentLocation),
                            titleColor = navigationActions.getTitleColorTopBar(currentLocation),
                        )
                    } else {
                        lastScreen = currentLocation
                        TopBar(
                            topBarColor = navigationActions.getColorTopBar(currentLocation),
                            title = navigationActions.getTextTopBar(currentLocation),
                            titleStyle = navigationActions.getTitleStyleTopBar(currentLocation),
                            titleColor = navigationActions.getTitleColorTopBar(currentLocation),
                            //description = navigationActions.getDescriptionTopBar(currentLocation)
                        )
                    }
                }
            }
        ) { innerPadding ->


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AppNavigation(
                    navController = navController,
                    drawerViewModel = drawerViewModel
                )
            }
        }
    }
}