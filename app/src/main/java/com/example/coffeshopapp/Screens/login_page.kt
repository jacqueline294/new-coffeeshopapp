package com.example.coffeshopapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeshop.R
import com.example.coffeshopapp.Credentials
import com.example.coffeshopapp.Routes

@Composable
fun LoginPage() {
    // Define gradient for background
    val gradient = Brush.horizontalGradient(
        colors = listOf(Color.White, Color.Cyan),
        startX = 0f,
        endX = 1000f
    )

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient)
            .padding(horizontal = 16.dp) // Add padding for content
    ) {
        // Coffee Shop Logo
        Image(
            painter = painterResource(id = R.drawable.coffeelogo),
            contentDescription = "Logo",
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
        )

        // Welcome Text
        Text(
            text = "Welcome, Please Log in",
            style = TextStyle(fontFamily = FontFamily.Cursive),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Email Field
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))


        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        var errorMessage by remember { mutableStateOf("") }
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }


        Button(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    // Perform login validation
                    val credentials = Credentials(email, password)
                    if (credentials.validate()) {
                        navController.navigate(Routes.Screen.Home.route)
                    } else {
                        errorMessage = "Invalid email or password. Please try again."
                    }
                } else {
                    errorMessage = "Please enter email and password."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}
