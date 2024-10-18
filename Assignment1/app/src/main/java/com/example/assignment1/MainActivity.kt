package com.example.assignment1

import screens.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment1.ui.theme.Assignment1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController =  navController, startDestination = "WelcomePage") {
                    composable("WelcomePage") {
                        WelcomePage(
                            navigateToSignIn = { navController.navigate("SignIn") },
                            navigateToSignUp= { navController.navigate("SignUp") }
                        )
                    }
                    composable("SignIn") {
//                        LogInPage(navigateToHome = { navController.popBackStack("WelcomePage", inclusive = true)})
                        LogInPage(
                            navigateToHome = { navController.navigate("HomePage")},
                            navigateToSignUp= { navController.navigate("SignUp") }
                        )
                    }
                    composable("SignUp") {
//                        LogInPage(navigateToHome = { navController.popBackStack("WelcomePage", inclusive = true)})
                        RegistrationPage(
                            navigateToHome = { navController.navigate("HomePage")},
                            navigateToSignIn = { navController.navigate("SignIn") }
                        )
                    }
                    composable("HomePage") {
                        HomePage(navigateBack = { navController.popBackStack("WelcomePage", inclusive = false)})
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun WelcomePageAppPreview() {
//    Assignment1Theme {
//        WelcomePage()
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun RegistrationPagePreview() {
//    Assignment1Theme {
//        RegistrationPage()
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun LogInPagePreview() {
//    Assignment1Theme {
//        LogInPage()
//    }
//}
//
//@Preview(showBackground = true,  showSystemUi = true)
//@Composable
//fun HomePagePreview() {
//    Assignment1Theme {
//        HomePage()
//    }
//}