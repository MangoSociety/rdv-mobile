package ui.chat.current

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import components.Star
import components.StarAndStick
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.back_arrow
import rdv_mobile.shared.generated.resources.gift
import ui.chat.current.store.CurrentChatStore
import ui.chat.main.ChatMainComponent
import ui.chat.main.store.ChatMainStore

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CurrentChatTopBar(
    idUser:Int,
    onBackClick: () -> Unit,
    onProfileClick: () -> Unit
){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
        {
            Image(
                painterResource(Res.drawable.back_arrow),
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 28.dp)
                    .size(24.dp)
                    .align(Alignment.CenterStart)
                    .clickable {
                        onBackClick()
                    }
            )
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                val chat: ChatMain = ChatMain().find { it.id == idUser }!!
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 40.dp)
                            .size(48.dp)
                            .clickable {
                                onProfileClick()
                            }
                    ) {
                        AsyncImage(
                            model = chat.info.avatarMain,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        if (chat.info is ChatSealed.ChatSelf && chat.info.isBirthday) {
                            Image(
                                painterResource(Res.drawable.gift),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .offset(x = 8.dp,y = -8.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(
                            color = Color(0xFF594888),
                            text = chat.info.titleMain,
                            fontSize = 20.sp
                        )
                        if (chat.messages.any { it.isTyping }) {
                            IsTyping(true, false)
                        } else if (chat.messages.any { it.online }) {
                            IsTyping(false, true)
                        }
                    }
                }
                CurrentChatStars()
            }
        }

}