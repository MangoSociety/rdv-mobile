package ui.chat.current

import androidx.compose.runtime.Composable

@Composable
fun IsTyping(isTyping: Boolean, online: Boolean){
    when  {
        isTyping -> CurrentChatAnimatedTyping()
        else -> Online(online)
    }
}