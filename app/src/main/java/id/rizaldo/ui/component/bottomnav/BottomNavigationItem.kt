package id.rizaldo.ui.component.bottomnav

import androidx.compose.material.icons.Icons
import id.rizaldo.R
import io.eyram.iconsax.IconSax

data class NavigationItem(
    val title: Int,
    val icon: Int,
    val inactiveIcon : Int,
    val screen: String,
)

val navigationsItem = listOf(
    NavigationItem(
        title = R.string.text_home,
        icon =  IconSax.Bold.Home,
        inactiveIcon =IconSax.Linear.Home,
        screen = "homeScreen"

    ),
    NavigationItem(
        title = R.string.text_leads,
        icon =  IconSax.Bold.UserTag,
        inactiveIcon =IconSax.Linear.UserTag,
        screen = "LeadScreen"
    ),
    NavigationItem(
        title = R.string.text_shop,
        icon = IconSax.Bold.ShoppingBag,
        inactiveIcon = IconSax.Linear.ShoppingBag,
        screen = "shopScreen"
    ),
    NavigationItem(
        title = R.string.text_account,
        icon =  IconSax.Bold.LocationTick,
        inactiveIcon = IconSax.Linear.LocationTick,
        screen = "accountScreen"
    ),
)