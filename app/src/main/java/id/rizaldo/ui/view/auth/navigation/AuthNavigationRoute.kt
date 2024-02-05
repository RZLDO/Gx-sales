package id.rizaldo.ui.view.auth.navigation

sealed class AuthNavigationRoute(val route : String ){
    object SplashScreen : AuthNavigationRoute("splashScreen")
    object LoginScreen : AuthNavigationRoute("loginScreen")
}