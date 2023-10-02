package ru.serguun42.android.ats.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.serguun42.android.ats.data.mock.BusinessDetailsMockData
import ru.serguun42.android.ats.data.mock.PersonalDetailsMockData
import ru.serguun42.android.ats.ui.screens.BusinessDetailsScreen
import ru.serguun42.android.ats.ui.screens.PersonalDetailsScreen
import ru.serguun42.android.ats.ui.screens.SettingsScreen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "personal") {
        composable("personal") {
            PersonalDetailsScreen(PersonalDetailsMockData())
        }
        composable("business") {
            BusinessDetailsScreen(BusinessDetailsMockData())
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}