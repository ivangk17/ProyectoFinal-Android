package com.example.login.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login.components.navigationdrawer.NavDrawer2
import com.example.login.components.topbars.NavigationTopBar
import com.example.login.components.topbars.TopBar
import com.example.login.navigation.AppNavigation
import com.example.login.navigation.AppNavigationActions
import com.example.login.navigation.AppNavigationActions.Companion.routesWithDrawer
import com.example.login.ui.viewmodels.MainActivityViewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = Closed)
    val scope = rememberCoroutineScope()
    val isAuthenticated by mainViewModel.isAuthenticated.collectAsState()
    val routesWithDrawer = AppNavigationActions.routesWithDrawer
    val currentLocation = navController.currentBackStackEntryAsState().value?.destination?.route
    val email by mainViewModel.email.collectAsState()
    // mainViewModel.updateEmail()

    // var lastScreen: String? = ""
    /*
        LaunchedEffect(Unit) {
            if (isAuthenticated) {
                mainViewModel.updateEmail()
            }
        }
    */
    // Abre el drawer cuando sea necesario
    LaunchedEffect(mainViewModel.drawerShouldBeOpened.collectAsState().value) {
        if (mainViewModel.drawerShouldBeOpened.value && currentLocation in routesWithDrawer) {
            drawerState.open()
            mainViewModel.resetOpenDrawerAction()
        }
    }

    if (currentLocation in routesWithDrawer) {
        ModalNavigationDrawer(
            drawerContent = {
                NavDrawer2(
                    mainViewModel = mainViewModel,
                    email = email,
                    navigationActions = AppNavigationActions(navController),
                    drawerState = drawerState,
                    scope = scope
                )
            },
            drawerState = drawerState,
            gesturesEnabled = currentLocation in routesWithDrawer
        ) {
            AppScaffoldContent(navController, currentLocation, drawerState, scope)
        }
    } else {
        AppScaffoldContent(navController, currentLocation, drawerState, scope)
    }
}

@Composable
fun AppScaffoldContent(
    navController: NavHostController,
    currentLocation: String?,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    val navigationActions = AppNavigationActions(navController)
    var lastScreen: String? = ""
    val showMenuIcon = currentLocation in routesWithDrawer

    Scaffold(
        topBar = {
            if (!navigationActions.hideTopBar(currentLocation)) {

                if (navigationActions.getNavigationTopBar(currentLocation)) {
                    NavigationTopBar(
                        onClick = { navController.popBackStack() },
                        quitScreen = { navController.navigate(lastScreen.toString()) },
                        topBarColor = navigationActions.getColorTopBar(currentLocation),
                        title = navigationActions.getTextTopBar(currentLocation),
                        titleStyle = navigationActions.getTitleStyleTopBar(currentLocation),
                        titleColor = navigationActions.getTitleColorTopBar(currentLocation),
                        onMenuClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                } else {
                    lastScreen = currentLocation
                    TopBar(
                        topBarColor = navigationActions.getColorTopBar(currentLocation),
                        title = navigationActions.getTextTopBar(currentLocation),
                        titleStyle = navigationActions.getTitleStyleTopBar(currentLocation),
                        titleColor = navigationActions.getTitleColorTopBar(currentLocation),
                        showMenuIcon = showMenuIcon,
                        onMenuClick = {
                            scope.launch {
                                drawerState.open() // Abre el drawer al hacer clic en el ícono de menú
                            }
                        }
                    )
                }
            }
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AppNavigation(navController)
            }
        }
    )
}
