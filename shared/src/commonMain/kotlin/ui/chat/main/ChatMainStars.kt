package ui.chat.main

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
fun BoxScope.ChatMainStars(){
    Row(
        modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
    ) {
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x=12.dp),
            star = Star(20.dp, 0.07f, 0.5f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )

        StarAndStick(
            modifier = Modifier.weight(2f).offset(x=0.dp),
            star = Star(20.dp, 0.12f, 0.7f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )

        StarAndStick(
            modifier = Modifier.weight(2f).offset(x=-40.dp),
            star = Star(20.dp, 0.05f, 0.4f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x=40.dp),
            star = Star(20.dp, 0.05f, 0.5f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x=8.dp),
            star = Star(20.dp, 0.17f, 0.3f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
        StarAndStick(
            modifier = Modifier.weight(2f).offset(x=-36.dp),
            star = Star(20.dp, 0.1f, 0.4f, Color(0xFFFFF4BA), 200.dp, 1200.dp)
        )
    }
}