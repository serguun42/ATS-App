package ru.serguun42.android.ats.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.serguun42.android.ats.ui.screens.BusinessDetailsScreen
import ru.serguun42.android.ats.ui.screens.PersonalDetailsScreen
import ru.serguun42.android.ats.ui.screens.SettingsScreen

@Composable
fun NavigationGraph(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navHostController, startDestination = "personal") {
        composable("personal") {
            PersonalDetailsScreen()
        }
        composable("business") {
            BusinessDetailsScreen(modifier)
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}