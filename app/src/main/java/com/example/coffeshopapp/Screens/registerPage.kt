package com.example.coffeshopapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeshop.R
import com.example.coffeshopapp.Routes




@Composable
fun RegistrationPage() {
    val gradient = Brush.horizontalGradient(
        colors = listOf(Color.White, Color.Cyan),
        startX = 0f,
        endX = 1000f
    )


    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .fillMaxSize()
            .background(brush = gradient)
    ){
        Image(painter = painterResource(id = R.drawable.coffeelogo), contentDescription = "Logo")

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Welcome Sign up Here",
            style = TextStyle(fontFamily = FontFamily.Cursive),
            fontSize = 32.sp,
            fontWeight= FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        val name = remember { mutableStateOf("") }
        OutlinedTextField(value = name.value, onValueChange =
        { name.value = it }, label = {
            Text(text = "Name")
        })
        Spacer(modifier = Modifier.height(4.dp))

        val email = remember { mutableStateOf("") }
        OutlinedTextField(value = email.value, onValueChange =
        { email.value = it }, label = {
            Text(text = "Email Address")
        })
        Spacer(modifier = Modifier.height(4.dp))

        val password = remember { mutableStateOf("") }
        OutlinedTextField(value = password.value, onValueChange =
        { password.value = it }, label = {
            Text(text = "Create Password")
        })

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {

            handleFormSubmission(name.value, email.value, password.value, navController)
        }) {
            Text(text = "Sign Up")
        }
    }
}





fun handleFormSubmission(name: String, email: String, password: String, navController: NavController) {
    println("Name: $name, Email: $email, Password: $password")
    navController.navigate(Routes.Screen.Login.route)
}

