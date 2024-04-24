package com.example.coffeshopapp.Screens


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "LoginPage") {
        composable("login") { LoginPage() }
        composable("SignUp") { RegistrationPage() }
        composable("drinks") { DrinksListPage() }
        composable("map") { MapPage() }
    }
}



