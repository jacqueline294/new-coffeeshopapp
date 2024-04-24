package com.example.coffeshopapp

object Routes {
    sealed class Screen(val route: String) {

        object SignUp : Screen("login_page")
        object Login : Screen("registerPage")
        object Home : Screen("Drinklist")
    }
}