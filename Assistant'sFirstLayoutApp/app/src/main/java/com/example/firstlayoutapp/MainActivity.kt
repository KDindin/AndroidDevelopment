package com.example.firstlayoutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstlayoutapp.screens.SignInScreen
import com.example.firstlayoutapp.screens.WelcomeScreen
import com.example.firstlayoutapp.ui.theme.FirstLayoutAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstLayoutAppTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize() ,
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
                val navController = rememberNavController()
                NavHost(navController =  navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomeScreen(navigateToSignIn = { navController.navigate("signin") })
                    }
                    composable("signin") {
                        SignInScreen(navigateBack = { navController.popBackStack("welcome", inclusive = true)})
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name : String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstLayoutAppTheme {
        Greeting("Android")
    }
}