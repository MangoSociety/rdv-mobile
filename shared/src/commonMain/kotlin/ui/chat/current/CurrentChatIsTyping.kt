package ui.chat.current

import androidx.compose.runtime.Composable
import ui.chat.main.AnimatedTyping

@Composable
fun IsTyping(isTyping: Boolean, online: Boolean){
    when  {
        isTyping -> CurrentChatAnimatedTyping()
        else -> Online(online)
    }
}