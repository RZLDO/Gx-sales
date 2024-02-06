package id.rizaldo.ui.view.home.navigation

sealed class HomeNavigationRoute(val route : String){
    object HomeScreen : HomeNavigationRoute("HomeScreen")
}