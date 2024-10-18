package com.example.assignment1

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment1.adminScreens.DetailAdminPage
import com.example.assignment1.adminScreens.HomeAdminPage
import com.example.assignment1.detail.DetailViewModel
import com.example.assignment1.home.HomeViewModel
import com.example.assignment1.login.LoginViewModel
import screens.*

enum class LoginRoutes{
    SignUp,
    SignIn
}
enum class HomeRoutes{
    Home,
    Detail,
    Welcome
}

enum class NestedRoutes{
    Main,
    Login
}

//enum class UserRoutes{
//    Home,
//    Info
//}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
    detailViewModel: DetailViewModel,
    homeViewModel:HomeViewModel
){
    NavHost(
        navController = navController,
        startDestination = NestedRoutes.Login.name
    ){
//        composable(HomeRoutes.Welcome.name) {
//            WelcomePage(
//                navigateToSignIn = { navController.navigate(LoginRoutes.SignIn.name) },
//                navigateToSignUp= { navController.navigate(LoginRoutes.SignUp.name) }
//            )
//        }

        authGraph(navController, loginViewModel)
        homeGraph(
            navController = navController,
            detailViewModel,
            homeViewModel
        )
//        composable(route = LoginRoutes.SignIn.name){
//            LogInPage(navigateToHome = {
//                navController.navigate(HomeRoutes.Home.name){
//                    launchSingleTop = true
//                    popUpTo(route = LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//            },
//                loginViewModel = loginViewModel
//            ){
//                navController.navigate(LoginRoutes.SignUp.name){
//                    launchSingleTop = true
//                    popUpTo(LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//            }
//        }
//
//        composable(route = LoginRoutes.SignUp.name){
//            RegistrationPage(navigateToHome = {
//                navController.navigate(HomeRoutes.Home.name){
//                    popUpTo(route = LoginRoutes.SignUp.name){
//                        inclusive = true
//                    }
//                }
//            },
//                loginViewModel = loginViewModel
//            ){
//                navController.navigate(LoginRoutes.SignIn.name)
//             }
//        }


    }
}

fun NavGraphBuilder.authGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
){
    navigation(
        startDestination = LoginRoutes.SignIn.name,
        route = NestedRoutes.Login.name
    ){
        composable(route = LoginRoutes.SignIn.name){
            LogInPage(navigateToHome = {
                navController.navigate(NestedRoutes.Main.name){
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel
            ){
                navController.navigate(LoginRoutes.SignUp.name){
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            }
//            LogInPage(navigateToHome = {
//                navController.navigate(UserRoutes.Home.name){
//                    launchSingleTop = true
//                    popUpTo(route = LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//            }, navigateToSignUp = {
//                    navController.navigate(LoginRoutes.SignUp.name){
//                    launchSingleTop = true
//                    popUpTo(LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//            },
//                loginViewModel = loginViewModel
//            ) {
//                navController.navigate(NestedRoutes.Main.name){
//                    launchSingleTop = true
//                    popUpTo(LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//
//            }
        }

//        composable(route = UserRoutes.Home.name){
//            BooksHomePage {
//                navController.navigate(LoginRoutes.SignIn.name)
//            }
//        }
//        composable(route = UserRoutes.Info.name){
//            BooksHomePage {
//                navController.navigate(LoginRoutes.SignIn.name)
//            }
//        }


        composable(route = LoginRoutes.SignUp.name){
            RegistrationPage(navigateToHome = {
                navController.navigate(NestedRoutes.Main.name){
                    popUpTo(route = LoginRoutes.SignUp.name){
                        inclusive = true
                    }
                }
            },
                loginViewModel = loginViewModel
            ){
                navController.navigate(LoginRoutes.SignIn.name)
            }
        }
    }
}

fun NavGraphBuilder.homeGraph(
    navController: NavHostController,
    detailViewModel: DetailViewModel,
    homeViewModel: HomeViewModel
){
    navigation(
        startDestination = HomeRoutes.Home.name,
        route = NestedRoutes.Main.name,
    ){
        composable(HomeRoutes.Home.name){
            HomeAdminPage(
                homeViewModel = homeViewModel,
                onBookClick = {
                              bookId ->
                    navController.navigate(
                        HomeRoutes.Detail.name + "?id=$bookId"
                    ){
                        launchSingleTop = true
                    }
                },
                navigateToDetailPage = {
                    navController.navigate(HomeRoutes.Detail.name)
                }
            ) {
                navController.navigate(NestedRoutes.Login.name){
                    launchSingleTop = true
                    popUpTo(0){
                        inclusive = true
                    }
                }
            }
        }

        composable(
            route = HomeRoutes.Detail.name + "?id={id)",
            arguments = listOf(navArgument("id"){
                type = NavType.StringType
                defaultValue = ""
            })
        ){
            entry ->
            DetailAdminPage(
                homeViewModel = homeViewModel ,
                detailViewModel = detailViewModel,
                bookId = entry.arguments?.getString("id") as String,
                onNavigate = { navController.navigate(NestedRoutes.Login.name) }
            ) {
                navController.navigateUp()
            }

        }
    }

}



















