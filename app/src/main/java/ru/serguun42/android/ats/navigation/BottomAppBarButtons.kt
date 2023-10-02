package ru.serguun42.android.ats.navigation

import ru.serguun42.android.ats.R

sealed class BottomAppBarButtons(val title: String, val iconId: Int, val route: String) {
    object PersonalDetailsScreen :
        BottomAppBarButtons("Personal", R.drawable.baseline_person_24, "personal")

    object BusinessDetailsScreen :
        BottomAppBarButtons("Business", R.drawable.baseline_business_24, "business")

    object SettingsScreen :
        BottomAppBarButtons("Settings", R.drawable.baseline_settings_24, "settings")
}