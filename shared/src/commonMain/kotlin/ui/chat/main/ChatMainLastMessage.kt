package ui.chat.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LastMessage(lastMessage: String) {
    Text(
        color = Color(0xFF594888),
        text = lastMessage,
        fontSize = 12.sp,
        modifier = Modifier.padding(top = 8.dp)
    )
}
