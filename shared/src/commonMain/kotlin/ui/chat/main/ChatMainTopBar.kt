package ui.chat.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.Star
import components.StarAndStick
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.chat_title
import rdv_mobile.shared.generated.resources.support
import ui.chat.main.store.ChatMainStore

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatMainTopBar(component: ChatMainComponent){
    val state by component.state.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding( horizontal = 16.dp)
    )
    {
        ChatMainStars()
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 36.dp),
            text = stringResource(Res.string.chat_title),
            color = Color(0xFF594888),
            fontSize = 24.sp
        )
        val interactionSource = remember { MutableInteractionSource() }
        Box(
            modifier = Modifier
                .size(56.dp)
                .offset(x=12.dp)
                .padding(top = 16.dp, end = 16.dp)
                .align(Alignment.CenterEnd)
                .clickable (
                    interactionSource = interactionSource,
                    indication = null
                ){
                    component.onIntent(ChatMainStore.Intent.OnSupportClicked)
                }
        ) {
            Image(
                painterResource(Res.drawable.support),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxSize()
            )
            //сделать чтобы фон накладывался по кругу(подложка под число)
            Column(
                modifier = Modifier
                    .offset(x = 0.dp, y = -8.dp)
                    .align(Alignment.TopEnd)
                    .border(1.dp, Color(0xFF594888), CircleShape)//4.dp слишком жирно
                    .padding(4.dp)
            ) {
                Text(
                    text = "35",
                    fontSize = 8.sp
                )
            }
        }
    }
}