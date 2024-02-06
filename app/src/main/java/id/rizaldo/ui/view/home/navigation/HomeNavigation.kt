package id.rizaldo.ui.view.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.rizaldo.ui.view.home.HomeScreen

fun NavGraphBuilder.homeNavigation(navController: NavController){
    navigation(startDestination = HomeNavigationRoute.HomeScreen.route, route = "home"){
        composable(HomeNavigationRoute.HomeScreen.route){
            HomeScreen(navController = navController)
        }
    }
}