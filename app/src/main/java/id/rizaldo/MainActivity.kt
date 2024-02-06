package id.rizaldo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.NavHost
import dagger.hilt.android.AndroidEntryPoint
import id.rizaldo.ui.component.bottomnav.BottomNavigationBar
import id.rizaldo.ui.theme.GxsalesaoosTheme
import id.rizaldo.ui.view.auth.navigation.authNavigation
import id.rizaldo.ui.view.home.navigation.homeNavigation
import io.eyram.iconsax.IconSax

@Suppress("UNUSED_EXPRESSION")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = NavHostController(this).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
            navigatorProvider.addNavigator(DialogNavigator())
        }
        setContent {
            GxsalesaoosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Scaffold (
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        },
                        containerColor = Color.White
                    ){ innerPadding ->
                        innerPadding
                        NavHost(
                            navController = navController, startDestination =  "AuthRoute"){
                            authNavigation(navController)
                            homeNavigation(navController)
                        }
                    }
                }
            }
        }
    }
}

