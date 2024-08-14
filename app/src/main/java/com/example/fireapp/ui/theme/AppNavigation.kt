package com.example.fireapp.ui.theme

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fireapp.ui.screens.AppViewModel
import com.example.fireapp.ui.screens.LoginScreen

enum class Screen(val route:String){
    Home("home"),
    Login("login")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val vm:AppViewModel= viewModel()
    val nc = rememberNavController()
    val state= vm.appState.collectAsState().value
    NavHost(navController = nc, startDestination = Screen.Login.route) {
        composable(Screen.Login.route){
            LoginScreen(modifier=modifier,navController =nc, state = state)
        }
        composable(Screen.Home.route){

        }
    }

}