package ui.chat.current

import BackgroundColor
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import components.Star
import components.StarAndStick
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.back_arrow
import rdv_mobile.shared.generated.resources.chat_search
import rdv_mobile.shared.generated.resources.chat_title
import rdv_mobile.shared.generated.resources.dot
import rdv_mobile.shared.generated.resources.female_gender
import rdv_mobile.shared.generated.resources.gift
import rdv_mobile.shared.generated.resources.male_gender
import rdv_mobile.shared.generated.resources.search
import rdv_mobile.shared.generated.resources.send_message
import rdv_mobile.shared.generated.resources.smile_transparent
import rdv_mobile.shared.generated.resources.support
import rdv_mobile.shared.generated.resources.write_message
import ui.chat.main.AnimatedTyping
import ui.chat.main.Chat
import ui.chat.main.ChatMain
import ui.chat.main.ChatMainComponent
import ui.chat.main.ChatSealed
import ui.chat.main.DrawingOrNo
import ui.chat.main.Gender
import ui.chat.main.GenderDrawadle
import ui.chat.main.LastMessage
import ui.chat.main.UserMessage
import ui.chat.main.VisibleMessage
import ui.chat.main.store.ChatMainStore
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun CurrentChatScreen(component: ChatMainComponent) {
    val state by component.state.collectAsState()
    val idUser = 4

    Scaffold(
        backgroundColor = BackgroundColor,
        topBar = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
            {
                Image(
                    painterResource(Res.drawable.back_arrow),
                    contentDescription = null,
                    modifier = Modifier.padding(vertical = 28.dp).size(24.dp).align(Alignment.CenterStart)
                )
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val chat: ChatMain = ChatMain().find { it.id == idUser }!!
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Box(modifier = Modifier.padding(start = 40.dp).size(48.dp)) {
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
                            if (chat.info is ChatSealed.ChatSelf){
                                chat.messages.forEach { message ->  IsTyping(message.isTypung, message.online) }
                            }
                        }
                    }
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
            }
        }
    )
    {
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
                    if (chat.info is ChatSealed.ChatSelf) {
                        chat.messages.forEach { item{ChatBubble(it.message, it.id, it.avatar) }}
                    }
                    else{
                        chat.messages.forEach { item{ChatBubble(it.message, it.id, it.avatar) }}
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
                        )
                    },
                    trailingIcon = {
                        Image(
                            painterResource(Res.drawable.send_message),
                            contentDescription = null,
                            modifier = Modifier
                                .size(44.dp)
                                .padding(end = 8.dp)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFFAF7FF),
                        focusedContainerColor = Color(0xFFFAF7FF),
                        focusedIndicatorColor = Color(0xFFFAF7FF),
                        unfocusedIndicatorColor = Color(0xFFFAF7FF),
                    ),
                    placeholder = {
                        Text(stringResource(Res.string.write_message),
                            color = Color(0xCC594888))
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
}

//@Composable
//fun OurMessage(text: String) {
//    ChatBubble(text, true)
//}
//@Composable
//fun TheirMessage(text: String, idChat: Int) {
//    val chat: Chat = Chat().find { it.id == idChat }!!
//    if (chat.data.gender == Gender.OTHER) {
//        Row {
//            AvatarGroup(chat.id)
//            ChatBubble(text, false)
//        }
//    }
//    else{
//        ChatBubble(text, false)
//    }
//}

@Composable
fun NewMessage() {}

@Composable
fun AvatarGroup(idUser: Int){
    val chat: Chat = Chat().find { it.id == idUser }!!
    AsyncImage(
        model = chat.data.avatar,
        contentDescription = null,
        modifier = Modifier
            .clip(CircleShape)
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ChatBubble(message: String, idUser: Int, avatar: String) {

    Box(modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        var xOffset: Dp
        var yOffset: Dp
        var xOffsetBox: Dp
        var alignment:Alignment
        var colorBack: Color
        if (idUser == 1) {
            xOffset = -4.dp
            xOffsetBox = 0.dp
            yOffset = 30.dp
            colorBack = Color(0xFFE1D2FE)
            alignment = Alignment.TopEnd
        }
        else{
                AsyncImage(
                    model = avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .align(Alignment.CenterStart),
                    contentScale = ContentScale.Crop
                )

            xOffset = 48.dp
            yOffset = 20.dp
            xOffsetBox = 52.dp
            colorBack = Color(0xFFFAF7FF)
            alignment = Alignment.CenterStart
        }
        // Стилизация основного баллона
        Box(
            modifier = Modifier
                .offset(x=xOffsetBox)
                .clip(RoundedCornerShape(8.dp))
                .background(colorBack)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(alignment)
        ) {
            Text(
                text = message,
                color = Color(0xFF594888)
            )
        }
        // Рисование "хвостика" баллона
        Canvas(
            modifier = Modifier
                .padding(start = 8.dp,)
                .offset(x=xOffset, y = yOffset)// Регулируйте позиционирование хвостика
                .size(12.dp, 12.dp)
                .align(alignment)
        ) {
            val path = androidx.compose.ui.graphics.Path().apply {
                moveTo(x = 0f, y = 0f) // Начальная точка
                lineTo(x = size.width, y = 0f) // Верхняя точка треугольника
                lineTo(x = size.width / 2, y = size.height) // Нижняя центральная точка
                close() // Замыкает путь
            }
            drawPath(
                path = path,
                color = colorBack// Цвет треугольника
            )
        }
    }
}


@Composable
fun IsTyping(isTyping: Boolean, online: Boolean){
    when  {
        isTyping -> AnimatedTyping()
        else -> Online(online)
    }
}


@Composable
fun AnimatedTyping() {
    var dots by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        while (true) {
            for (i in 0..3) {
                dots = ".".repeat(i)
                delay(500)
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterStart),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "Печатает$dots",
            color = Color(0xFF594888),
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 12.sp
        )
    }
}

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

sealed class ChatItemState {

    data object NewMessage : ChatItemState()
    data class TheirMessage(val text: String, val group: Boolean): ChatItemState()
    data class OurMessage(val text: String): ChatItemState()

}

