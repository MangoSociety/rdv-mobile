package ui.chat.current

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Online(online: Boolean){
    when (online) {
        true -> Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.CenterStart),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "В сети",
                color = Color(0xFF594888),
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 12.sp
            )
        }
        else -> Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.CenterStart),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Не в сети",
                color = Color(0xFF594888),
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 12.sp
            )
        }
    }
}
