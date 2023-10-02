package ru.serguun42.android.ats.ui.screens

import TextFieldGeneric
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.serguun42.android.ats.R
import ru.serguun42.android.ats.data.mock.PersonalDetailsMockData
import ru.serguun42.android.ats.ui.theme.ATSTheme
import ru.serguun42.android.ats.ui.theme.EditorCardBackground
import ru.serguun42.android.ats.ui.theme.Primary600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalDetailsScreen(data: PersonalDetailsMockData, darkerBackground: Boolean = false) {
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Text("Who cares")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
                    .padding(16.dp, 32.dp)
                    .background(
                        if (darkerBackground) Color(0xFF555555) else Color.Transparent
                    ), verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(shape = RoundedCornerShape(10.dp), color = EditorCardBackground)
                        .padding(16.dp, 16.dp)
                        .paint(
                            painterResource(id = R.drawable.baseline_person_24),
                            alignment = Alignment.TopStart,
                        ), verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Fill personal details",
                        color = Primary600,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = (-0.4).sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 8.dp)
                    )

                    TextFieldGeneric(data.fullname, "Full name")
                    TextFieldGeneric(data.dob, "Date of birth (in YYYY-MM-DD format)")
                    TextFieldGeneric(data.jobTitle, "Desired job title")
                    TextFieldGeneric(data.locationCity, "Current location city")
                    TextFieldGeneric(data.locationCountry, "Current location country")
                }

                Button(
                    onClick = {
                        Toast.makeText(
                            context, "You've just applied with your details", Toast.LENGTH_SHORT
                        ).show()
                    }, modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Apply", fontWeight = FontWeight.Bold)
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun PersonalDetailsScreenPreview() {
    val mockData = PersonalDetailsMockData()

    ATSTheme {
        PersonalDetailsScreen(mockData, true)
    }
}