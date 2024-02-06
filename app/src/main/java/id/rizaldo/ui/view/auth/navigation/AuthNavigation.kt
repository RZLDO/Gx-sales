package id.rizaldo.ui.view.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.rizaldo.ui.view.auth.login.LoginScreen
import id.rizaldo.ui.view.auth.splash.SplashScreen

fun NavGraphBuilder.authNavigation(navController: NavController){
    navigation(startDestination = AuthNavigationRoute.SplashScreen.route , route = "AuthRoute"){
        composable(AuthNavigationRoute.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AuthNavigationRoute.LoginScreen.route){
            LoginScreen(navController = navController)
        }
    }
}