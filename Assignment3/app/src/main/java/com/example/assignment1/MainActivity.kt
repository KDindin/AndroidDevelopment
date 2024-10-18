package com.example.assignment1

import screens.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment1.detail.DetailViewModel
import com.example.assignment1.home.HomeViewModel
import com.example.assignment1.login.LoginViewModel
import com.example.assignment1.ui.theme.Assignment1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            val detailViewModel = viewModel(modelClass = DetailViewModel::class.java)
            val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
            Assignment1Theme {
                    Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background) {
                        Navigation(
                            loginViewModel = loginViewModel,
                            detailViewModel = detailViewModel,
                            homeViewModel = homeViewModel)
                    }
                }
            }
        }
    }


//@Preview(showBackground = true)
//@Composable
//fun WelcomePageAppPreview() {
//    Assignment1Theme {
//        WelcomePage(
//            navigateToSignIn = {},
//            navigateToSignUp = {}
//        )
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun RegistrationPagePreview() {
//    Assignment1Theme {
//        RegistrationPage(
//            navigateToHome = {},
//            navigateToSignIn = {}
//        )
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun LogInPagePreview() {
//    Assignment1Theme {
//        LogInPage(
//            navigateToHome = {},
//            navigateToSignUp = {}
//        )
//    }
//}

//@Preview(showBackground = true,  showSystemUi = true)
//@Composable
//fun HomePagePreview() {
//    Assignment1Theme {
//        HomeScreen()
//    }
//}
//@Preview(showBackground = true,  showSystemUi = true)
//@Composable
//fun InfoAboutBookPreview() {
//    Assignment1Theme {
//        InfoAboutBookPage()
//    }
//}
//@Preview(showBackground = true,  showSystemUi = true)
//@Composable
//fun BookHomeScreenPreview() {
//    Assignment1Theme {
//        BooksHomePage()
////        navigateBack = {}
//    }
//}