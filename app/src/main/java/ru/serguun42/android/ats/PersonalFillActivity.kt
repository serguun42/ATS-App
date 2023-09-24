package ru.serguun42.android.ats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import ru.serguun42.android.ats.data.mock.PersonalDetailsMockData
import ru.serguun42.android.ats.screens.PersonalDetailsScreen
import ru.serguun42.android.ats.ui.theme.ATSTheme

class PersonalFillActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ATSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val data = PersonalDetailsMockData()
                    PersonalDetailsScreen(data)
                }
            }
        }
    }
}