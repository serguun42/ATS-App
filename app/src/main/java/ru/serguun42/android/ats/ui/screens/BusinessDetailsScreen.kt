package ru.serguun42.android.ats.ui.screens

import TextFieldGeneric
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
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
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.ui.theme.ATSTheme
import ru.serguun42.android.ats.ui.theme.EditorCardBackground
import ru.serguun42.android.ats.ui.theme.Primary600
import ru.serguun42.android.ats.viewmodel.BusinessScreenViewModel

@Composable
fun BusinessDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: BusinessScreenViewModel = viewModel(),
    darkerBackground: Boolean = false
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val businessDetails = viewModel.dataState.observeAsState()
    val businessDetailsValue = businessDetails.value

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 32.dp)
            .background(
                if (darkerBackground) Color(0xFF555555) else Color.Transparent
            ), verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        if (!businessDetailsValue.isNullOrEmpty()) {
            items(businessDetailsValue.size) { businessDetailIndex ->
                BusinessDetailsCard(
                    businessDetails = businessDetailsValue[businessDetailIndex],
                    businessDetailsIndex = businessDetailIndex,
                    context = context,
                )
            }
        }
    }

//    if (!businessDetailsValue.isNullOrEmpty())
//        BusinessDetailsCard(
//            businessDetails = businessDetailsValue[0],
//            businessDetailsIndex = 0,
//            context = context,
//        )
}

@Composable
fun BusinessDetailsCard(
    businessDetails: BusinessDetails,
    businessDetailsIndex: Int,
    context: Context
) {
    Text(text = "Business details ${businessDetailsIndex + 1}")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(10.dp), color = EditorCardBackground)
            .padding(16.dp, 16.dp)
            .paint(
                painterResource(id = R.drawable.baseline_business_24),
                alignment = Alignment.TopStart
            )
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
            label = "Company name",
            getter = { businessDetails.companyName },
            setter = { businessDetails.companyName = it },
        )
        TextFieldGeneric(
            label = "Company location",
            getter = { businessDetails.companyLocation },
            setter = { businessDetails.companyLocation = it },
        )
        TextFieldGeneric(
            label = "Job position",
            getter = { businessDetails.jobPosition },
            setter = { businessDetails.jobPosition = it },
        )
        TextFieldGeneric(
            label = "Start date of job",
            getter = { businessDetails.startDate },
            setter = { businessDetails.startDate = it },
        )
        TextFieldGeneric(
            label = "End date of job",
            getter = { businessDetails.endDate },
            setter = { businessDetails.endDate = it },
        )
        TextFieldGeneric(
            label = "Duties",
            getter = { businessDetails.duties },
            setter = { businessDetails.duties = it },
            multiline = true
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

@Preview(showBackground = true)
@Composable
fun WorkDetailsScreenPreview() {
    ATSTheme {
        BusinessDetailsScreen(Modifier, BusinessScreenViewModel(), true)
    }
}