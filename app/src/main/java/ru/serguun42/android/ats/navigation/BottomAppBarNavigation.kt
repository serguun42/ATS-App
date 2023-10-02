package ru.serguun42.android.ats.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.serguun42.android.ats.ui.theme.Primary900

@Composable
fun BottomAppBarNavigation(navController: NavHostController) {
    val listItems = listOf(
        BottomAppBarButtons.PersonalDetailsScreen,
        BottomAppBarButtons.BusinessDetailsScreen,
        BottomAppBarButtons.SettingsScreen
    )

    NavigationBar(
        modifier = Modifier.background(Primary900)
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "Icon"
                    )
                },
                label = { Text(text = item.title, fontSize = 12.sp) },
            )
        }
    }
}
