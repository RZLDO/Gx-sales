package id.rizaldo.ui.view.auth.splash

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import id.rizaldo.ui.view.auth.AuthViewModel
import id.rizaldo.ui.view.auth.navigation.AuthNavigationRoute
import id.rizaldo.ui.view.home.navigation.HomeNavigationRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    authViewModel: AuthViewModel = hiltViewModel(),
    navController: NavController
){
    LaunchedEffect(true) {
        val token = authViewModel.getUserToken()
        delay(3000)
        Log.d("token", token.toString())
        if (token == null) {
            navController.navigate(AuthNavigationRoute.LoginScreen.route)
        } else {
            navController.navigate(HomeNavigationRoute.HomeScreen.route)
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()){
        AsyncImage(
            model = "https://s3-alpha-sig.figma.com/img/fbe0/5ef9/a274b954e44aef88a75beecf25a1b8ae?Expires=1707696000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=bgZCSMpXnS7Cd61KmefUY-GD9L7uLRM6uKW9xiS5pXJESfeEYYq~mPei~ioeLPhJ4WV7k-dWEL~eyOkqaBKUmcdgIerhiJgBY9Oujke~ZhsnpAwI~86u8jgCTHYsLUyb7Hq72hklH~au7WuEDb9SIbH5NIhNfq-2kLlZxSCru2oB0Xtl1O78DhUG~GOcJZ5I59pvWbSii3Qq05EZLUYU1hNitgiUdxBkTxwxHE803ksGdnJyV~kxQf49ep1Ss3XETP6Jz-dIAEWI4r9AvInEWfIZcbAeMY1vhNsA305a0fAXjHyc9tgvCpUC8vUIPfi9bPCteP-Xz~O6DbkaSM9uSA__",
            contentDescription = "Image Apps")
    }
}