package ui.chat.main

import BackgroundColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import components.Star
import components.StarAndStick
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.chat_search
import rdv_mobile.shared.generated.resources.chat_title
import rdv_mobile.shared.generated.resources.dot
import rdv_mobile.shared.generated.resources.female_gender
import rdv_mobile.shared.generated.resources.gift
import rdv_mobile.shared.generated.resources.male_gender
import rdv_mobile.shared.generated.resources.name_user_maria
import rdv_mobile.shared.generated.resources.search
import rdv_mobile.shared.generated.resources.support
import ui.auth.signin.SignInComponent
import ui.auth.signin.store.SignInStore
import ui.chat.main.store.ChatMainStore
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun ChatMainScreen(component: ChatMainComponent) {
    val state by component.state.collectAsState()

    val interactionSource = remember { MutableInteractionSource() }

    // цвета надо брать из дизайн системы
    // не хватает шрифтов (используется отдельно установка размера текста, хотя это можно было установить через шрифты)

    Scaffold(
        backgroundColor = BackgroundColor,
        topBar = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( horizontal = 16.dp)
            )
            {
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
    ) {

        val trash = 4
        val message = remember { mutableStateOf("") }
        val users = Users()
        var resultUsers = remember { mutableStateOf(Users()) }
        var searchJob by remember { mutableStateOf<Job?>(null) }
        Column {
            state.events.forEach {
                when (it) {
                    is ChatMainStore.State.Event.ShowText -> {
                        Text("sdfdsf", fontSize = 36.sp)
                    }
                }
            }
            TextField(
                value = message.value,
                textStyle = TextStyle(color = Color(0xFF594888), fontSize = 18.sp),
                onValueChange = { newText ->
                    message.value = newText
                    component.onIntent(ChatMainStore.Intent.ProcessingSearch(newText))
                    resultUsers.value = (users.filter {
                        it.name.toLowerCase().contains(newText.toLowerCase())
                    }).toMutableList()
                },
                trailingIcon = {
                    Image(
                        painterResource(Res.drawable.search),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
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
                    Text(stringResource(Res.string.chat_search), color = Color(0xCC594888))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 12.dp)
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
            LazyColumn(
                contentPadding = PaddingValues(vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
            ) {
//                items(state.chats) {
//
//                }
                items(resultUsers.value) {
                    ChatWithUser(
                        it,
                        onChatClicked = { component.onIntent(ChatMainStore.Intent.OnChatClicked(it)) })
                }
            }
        }
    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatWithUser(
    user: TemporaryUserData,
    modifier: Modifier = Modifier,
    onChatClicked: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().clickable { onChatClicked.invoke(Random(324).nextInt()) }
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFF1EAFF),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Box() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(modifier = Modifier.size(48.dp)) {
                        AsyncImage(
                            model = user.photoUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        val genderDrawadle =
                            GenderDrawadle(user.gender, Res.drawable.female_gender, Res.drawable.male_gender)
                        genderDrawadle?.let {
                            Image(
                                painterResource(genderDrawadle),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(14.dp)
                                    .offset(y = -4.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(bottom = 14.dp, start = 12.dp)) {
                        Text(
                            color = Color(0xFF594888),
                            text = user.name,
                            fontSize = 14.sp
                        )
                        VisibleMessage(user.lastMessage, user.isTyping)
                    }
                }
                val unReadMessage = DrawingOrNo(user.unReadMessage, Res.drawable.dot)
                unReadMessage?.let {
                    Image(
                        painterResource(unReadMessage),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 19.dp)
                            .size(6.dp)
                            .align(Alignment.CenterEnd)
                    )
                }
            }
        }
        val birthday = DrawingOrNo(user.birthDate, Res.drawable.gift)
        birthday?.let {
            Image(
                painterResource(birthday),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopStart)
                    .offset(x = 15.dp, y = -5.dp),
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GenderDrawadle(
    gender: Gender,
    drawingFemale: DrawableResource,
    drawingMale: DrawableResource
): DrawableResource? {
    return when (gender) {
        Gender.FEMALE -> drawingFemale
        Gender.MALE -> drawingMale
        Gender.OTHER -> null
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun DrawingOrNo(choise: Boolean, drawing: DrawableResource): DrawableResource? {
    return when (choise) {
        true -> drawing
        else -> null
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun VisibleMessage(lastMassege: String, isTyping: Boolean) {
    when (isTyping) {
        true -> AnimatedTyping()
        else -> LastMessage(lastMassege)
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
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 12.sp
        )
    }
}

@Composable
fun LastMessage(lastMessage: String) {
    Text(
        color = Color(0xFF594888),
        text = lastMessage,
        fontSize = 12.sp,
        modifier = Modifier.padding(top = 8.dp)
    )
}




