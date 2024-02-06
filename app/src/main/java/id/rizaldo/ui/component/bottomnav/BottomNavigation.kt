package id.rizaldo.ui.component.bottomnav

import id.rizaldo.ui.theme.blackColor
import id.rizaldo.ui.theme.neutral300
import id.rizaldo.ui.theme.neutral500

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import io.eyram.iconsax.IconSax

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    fabOnClick : () -> Unit = {}
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        containerColor = Color.White,
        modifier = modifier) {
        navigationsItem.forEachIndexed { _, navigationItem ->
            NavigationBarItem(
                label = {
                    Text(text = stringResource(id = navigationItem.title),
                        style = MaterialTheme.
                        typography.bodyMedium.copy(
                            fontSize = 10.sp,)
                    )},
                selected = currentRoute == navigationItem.screen,
                onClick = {
                    navController.navigate(navigationItem.screen){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                icon = {
                    if(currentRoute == navigationItem.screen){
                        Image(
                            painter = painterResource(id = navigationItem.icon),
                            contentDescription = "")
                    }else{
                        Image(
                            painter = painterResource(id = navigationItem.inactiveIcon),
                            contentDescription = "")
                    }
                },
                colors = NavigationBarItemColors(
                    selectedIndicatorColor = Color.White,
                    disabledIconColor = neutral500,
                    selectedIconColor = neutral500,
                    selectedTextColor = blackColor,
                    unselectedIconColor = blackColor,
                    unselectedTextColor = neutral500,
                    disabledTextColor = blackColor
                )
            )
        }

    }
}
