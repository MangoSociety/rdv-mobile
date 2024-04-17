package ui.chat.current

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.chat_write_message
import rdv_mobile.shared.generated.resources.send_message
import rdv_mobile.shared.generated.resources.smile_transparent

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CurrentChatBody(
    idUser:Int,
    onSendClick: () -> Unit,
    onEmojiClick: () -> Unit
){
    val interactionSource = remember { MutableInteractionSource() }
    val chat: ChatMain = ChatMain().find { it.id == idUser }!!

    Surface (shape = RoundedCornerShape(8.dp),
        color = Color(0xFFF1EAFF),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize())
        {
            LazyColumn(
                modifier = Modifier
            ) {
                when(chat.info){
                    is ChatSealed.ChatSelf -> chat.messages.forEach { item{ChatBubble(it.message, it.id, null) }}
                    is ChatSealed.ChatGroup ->chat.messages.forEach { item{ChatBubble(it.message, it.id, it.avatar) }}
                }
            }
            Column(modifier = Modifier){

            }
            val message = remember { mutableStateOf("") }
            TextField(
                value = message.value,
                textStyle = TextStyle(color = Color(0xFF594888), fontSize = 18.sp),
                onValueChange = { newText ->
                    message.value = newText
                },
                maxLines = 3,
                leadingIcon = {
                    Image(
                        painterResource(Res.drawable.smile_transparent),
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp)
                            .padding(start = 8.dp)
                            .clickable {
                                onEmojiClick()
                            }
                    )
                },
                trailingIcon = {
                    Image(
                        painterResource(Res.drawable.send_message),
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp)
                            .padding(end = 8.dp)
                            .clickable {
                                onSendClick()
                            }
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFFAF7FF),
                    focusedContainerColor = Color(0xFFFAF7FF),
                    focusedIndicatorColor = Color(0xFFFAF7FF),
                    unfocusedIndicatorColor = Color(0xFFFAF7FF),
                ),
                placeholder = {
                    Text(
                        stringResource(Res.string.chat_write_message),
                        color = Color(0xCC594888)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp)
                    .heightIn(min = 40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .indicatorLine(
                        false, false,
                        interactionSource,
                        TextFieldDefaults.textFieldColors(),
                        focusedIndicatorLineThickness = 0.dp,
                        unfocusedIndicatorLineThickness = 0.dp
                    )
            )
        }

    }
}