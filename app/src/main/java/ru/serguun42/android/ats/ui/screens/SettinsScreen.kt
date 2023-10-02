package ru.serguun42.android.ats.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.serguun42.android.ats.ui.theme.ATSTheme
import ru.serguun42.android.ats.ui.theme.SettingsBlockBackground

@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    val checkedState = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 32.dp), verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(shape = RoundedCornerShape(10.dp), color = SettingsBlockBackground)
                .padding(16.dp, 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        Toast.makeText(
                            context, "Setting has been changed", Toast.LENGTH_SHORT
                        ).show()
                    })
                Text("Switch this on/off")
            }
        }

        Button(
            onClick = {
                Toast.makeText(
                    context, "Settings were saved", Toast.LENGTH_SHORT
                ).show()
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Save settings", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun SettingsDetailsScreenPreview() {
    ATSTheme {
        SettingsScreen()
    }
}