package com.example.firstlayoutapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun SignInScreen(modifier : Modifier = Modifier.fillMaxSize(), navigateBack: () -> Unit) {
    var array = listOf("user1", )
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text("Sign in screen")
        var userName by remember { mutableStateOf("") }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextField(value = userName , onValueChange = { userName = it })
            Button(onClick = navigateBack) {
                Text("Back")
            }
        }
    }
}