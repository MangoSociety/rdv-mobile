package ui.chat.current

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.Star
import components.StarAndStick

@Composable
fun BoxScope.CurrentChatStars(){
    Row(
        modifier = Modifier.fillMaxWidth().align(Alignment.TopEnd)
    ) {
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x = 240.dp),
            star = Star(20.dp, 0.05f, 0.2f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x = 140.dp),
            star = Star(20.dp, 0.1f, 0.3f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x = 40.dp),
            star = Star(20.dp, 0.02f, 0.15f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
    }
}