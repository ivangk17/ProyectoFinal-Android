package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login.components.MyAppTheme
import com.example.login.components.topbars.NavigationTopBar
import com.example.login.components.topbars.TopBar
import com.example.login.navigation.AppNavigationActions
import com.example.login.ui.screens.MainScreen
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModel
import com.example.login.ui.viewmodels.navdrawerviewmodel.DrawerViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          /*  val drawerViewModel = ViewModelProvider(this, DrawerViewModelFactory())
                .get(DrawerViewModel::class.java) */

            MyAppTheme {

                /*
            MyAppTheme {

                var lastScreen: String? = ""

                val navController = rememberNavController()
                val navigationActions = AppNavigationActions(navController)
                Scaffold(
                    topBar = {
                        val currentLocation = navController.currentBackStackEntryAsState().value?.destination?.route

                        if(!navigationActions.hideTopBar(currentLocation)) {
                            if(navigationActions.getNavigationTopBar(currentLocation)) {
                                NavigationTopBar(
                                    onClick = { navController.popBackStack() },
                                    quitScreen = { navController.navigate(lastScreen.toString())} ,
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
                    ){
                       // AppNavigation(navController,  drawerViewModel)

                       // MainScreen(drawerViewModel)
                    }
                }
            }
            */
                MainScreen()
            }
        }
    }
}


