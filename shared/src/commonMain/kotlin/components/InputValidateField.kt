package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelfManagedTextField(
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    validator: (String) -> Boolean,
    onValidationFailed: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    val backgroundColor = if (isError) Color(0xFFecdbee) else Color(0xFFF1EAFF) // Замените на нужный цвет фона
    val shadowColor = if (isError) Color.Red else Color.Gray // Замените на нужный цвет тени

    val interactionSource = remember { MutableInteractionSource() }

    Column(modifier = modifier) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(4.dp), clip = false)
            .border(width = 2.dp, color = if (isError) Color(0xFFC05555) else Color.Transparent)
            .background(backgroundColor, RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            BasicTextField(
                modifier = Modifier
                    .indicatorLine(false, false,
                        interactionSource,
                        TextFieldDefaults.textFieldColors(),
                        focusedIndicatorLineThickness = 0.dp,
                        unfocusedIndicatorLineThickness = 0.dp
                    ),
                cursorBrush = SolidColor(Color.Transparent),
                value = text,
                onValueChange = {
                    text = it
                    isError = !validator(text)
                    if (isError) onValidationFailed(text)
                },
                keyboardOptions = keyboardOptions,
                decorationBox = { innerTextField ->
                    if (text.isEmpty()) {
                        Text(label, style = MaterialTheme.typography.bodyLarge, color = Color(0xFFC3ACE9))
                    }
                    innerTextField()
                },
                singleLine = true
            )
        }

        if (isError) {
            Text(
                text = "Не правильно введен номер",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}