package ru.serguun42.android.ats.ui.screens

import TextFieldGeneric
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.serguun42.android.ats.R
import ru.serguun42.android.ats.ui.theme.ATSTheme
import ru.serguun42.android.ats.ui.theme.EditorCardBackground
import ru.serguun42.android.ats.ui.theme.Primary600
import ru.serguun42.android.ats.viewmodel.BusinessScreenViewModel

@Composable
fun BusinessDetailsScreen(
    viewModel: BusinessScreenViewModel = viewModel(),
    darkerBackground: Boolean = false
) {
    val context = LocalContext.current
    val businessDetails = viewModel.dataState.observeAsState()

    val businessDetailsValue = businessDetails.value

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 32.dp)
            .background(
                if (darkerBackground) Color(0xFF555555) else Color.Transparent
            ), verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        items(businessDetailsValue?.size ?: 0) { businessDetailIndex ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(shape = RoundedCornerShape(10.dp), color = EditorCardBackground)
                    .padding(16.dp, 16.dp)
                    .paint(
                        painterResource(id = R.drawable.baseline_business_24),
                        alignment = Alignment.TopStart
                    ), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Fill last workplace details",
                    color = Primary600,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-0.4).sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 8.dp)
                )

                TextFieldGeneric(
                    businessDetailsValue?.get(businessDetailIndex)?.companyName,
                    "Company name"
                )
                TextFieldGeneric(
                    businessDetailsValue?.get(businessDetailIndex)?.companyLocation,
                    "Company location"
                )
                TextFieldGeneric(
                    businessDetailsValue?.get(businessDetailIndex)?.jobPosition,
                    "Job position"
                )
                TextFieldGeneric(
                    businessDetailsValue?.get(businessDetailIndex)?.startDate,
                    "Start date of job"
                )
                TextFieldGeneric(
                    businessDetailsValue?.get(businessDetailIndex)?.endDate,
                    "End date of job"
                )
                TextFieldGeneric(
                    businessDetailsValue?.get(businessDetailIndex)?.duties,
                    "Duties",
                    true
                )

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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkDetailsScreenPreview() {
    ATSTheme {
        BusinessDetailsScreen(BusinessScreenViewModel(), true)
    }
}