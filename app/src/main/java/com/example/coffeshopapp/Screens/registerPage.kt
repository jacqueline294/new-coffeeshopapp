package com.example.coffeshopapp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.coffeshopapp.Credentials


@Composable
fun RegistrationPage() {
    var credentials by remember { mutableStateOf(Credentials()) }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        @Composable
        fun LoginField(onChange: (String) -> Unit, modifier: Modifier) {
            TextField(
                value = "",
                onValueChange = onChange,
                //label = { Text("Username") },
                modifier = modifier
            )
        }

        @Composable
        fun PasswordField(onChange: (String) -> Unit, modifier: Modifier) {
            TextField(
                value = "",
                onValueChange = onChange,
                //label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = modifier
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        LabeledCheckbox(
            onCheckChanged = {
                credentials = credentials.copy(remember = !credentials.remember)
            },
            isChecked = credentials.remember
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            enabled = credentials.isNotEmpty(),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            //Text("Register")
        }
    }
}

fun Button(
    enabled: Boolean,
    shape: RoundedCornerShape,
    modifier: Modifier,
    content: RowScope.() -> Unit
) {

}


@Composable
fun LoginField(onChange: Any, modifier: Modifier) {

}

@Composable
fun PasswordField(onChange: Any, modifier: Modifier) {

}

@Composable
fun LabeledCheckbox(onCheckChanged: () -> Unit, isChecked: Boolean) {

}




fun saveCredentials(credentials: Credentials) {

}











