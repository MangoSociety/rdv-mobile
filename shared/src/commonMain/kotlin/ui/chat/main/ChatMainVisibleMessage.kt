package ui.chat.main

import androidx.compose.runtime.Composable


@Composable
fun VisibleMessage(lastMassege: String, isTyping: Boolean) {
    when (isTyping) {
        true -> AnimatedTyping()
        else -> LastMessage(lastMassege)
    }
}
