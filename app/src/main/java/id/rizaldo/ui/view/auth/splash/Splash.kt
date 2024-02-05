package id.rizaldo.ui.view.auth.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage
import id.rizaldo.ui.view.auth.navigation.AuthNavigationRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
){
    LaunchedEffect(true) {
        delay(3000)
        navController.navigate(AuthNavigationRoute.LoginScreen.route)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()){
        AsyncImage(
            model = "https://s3-alpha-sig.figma.com/img/fbe0/5ef9/a274b954e44aef88a75beecf25a1b8ae?Expires=1707696000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=bgZCSMpXnS7Cd61KmefUY-GD9L7uLRM6uKW9xiS5pXJESfeEYYq~mPei~ioeLPhJ4WV7k-dWEL~eyOkqaBKUmcdgIerhiJgBY9Oujke~ZhsnpAwI~86u8jgCTHYsLUyb7Hq72hklH~au7WuEDb9SIbH5NIhNfq-2kLlZxSCru2oB0Xtl1O78DhUG~GOcJZ5I59pvWbSii3Qq05EZLUYU1hNitgiUdxBkTxwxHE803ksGdnJyV~kxQf49ep1Ss3XETP6Jz-dIAEWI4r9AvInEWfIZcbAeMY1vhNsA305a0fAXjHyc9tgvCpUC8vUIPfi9bPCteP-Xz~O6DbkaSM9uSA__",
            contentDescription = "Image Apps")
    }
}