package ru.serguun42.android.ats.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.serguun42.android.ats.ui.theme.ATSTheme

@Composable
fun PersonalDetailsScreen(name: String) {
    Column { Text(text = "Hello, $name") }
}

@Preview(showBackground = true)
@Composable
fun PersonalDetailsScreenPreview() {
    ATSTheme {
        PersonalDetailsScreen("Preview")
    }
}