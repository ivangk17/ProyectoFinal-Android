package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.login.components.MyAppTheme
import com.example.login.ui.screens.MainScreen
import com.example.login.ui.viewmodels.MainActivityViewmodel.MainViewModel
import com.example.login.ui.viewmodels.MainActivityViewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        val mainViewModel = ViewModelProvider(this, MainViewModelFactory())
                .get(MainViewModel::class.java)

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
                MainScreen(mainViewModel)
            }
        }
    }
}


