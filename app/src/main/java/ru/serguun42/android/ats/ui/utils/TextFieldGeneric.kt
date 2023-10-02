import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldGeneric(initialValue: String, label: String, multiline: Boolean = false) {
    var value by remember { mutableStateOf(initialValue) }

    var modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)

    if (multiline) modifier = modifier.height(150.dp)

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text(label) },
        placeholder = { Text("Do not leave this field empty") },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent
        )
    )
}