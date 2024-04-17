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
import rdv_mobile.shared.generated.resources.chat_write_message
import rdv_mobile.shared.generated.resources.dot
import rdv_mobile.shared.generated.resources.female_gender
import rdv_mobile.shared.generated.resources.gift
import rdv_mobile.shared.generated.resources.male_gender
import rdv_mobile.shared.generated.resources.search
import rdv_mobile.shared.generated.resources.send_message
import rdv_mobile.shared.generated.resources.smile_transparent
import rdv_mobile.shared.generated.resources.support
import ui.chat.current.store.CurrentChatStore
import ui.chat.main.Chat
import ui.chat.main.ChatMainComponent
import ui.chat.main.DrawingOrNo
import ui.chat.main.Gender
import ui.chat.main.LastMessage
import ui.chat.main.VisibleMessage
import ui.chat.main.store.ChatMainStore
import kotlin.random.Random

@Composable
internal fun CurrentChatScreen(component: CurrentChatComponent) {
    val idUser = 4

    val state by component.state.collectAsState()

    state.events.forEach {  event ->
        when(event) {
            is CurrentChatStore.State.Event.ShowText -> {
                Text(event.text)
            }
        }
    }

    Scaffold(
        backgroundColor = BackgroundColor,
        topBar = {
            CurrentChatTopBar(
                idUser = idUser,
                onBackClick = {
                    component.onIntent(CurrentChatStore.Intent.BackButton)
                },
                onProfileClick = {
                    component.onIntent(CurrentChatStore.Intent.OnInfoModelClicked(idUser))
                }
            )
        }
    )
    {
        CurrentChatBody(
            idUser = idUser,
            onSendClick = {
                component.onIntent(CurrentChatStore.Intent.BackButton)
            },
            onEmojiClick = {
                component.onIntent(CurrentChatStore.Intent.OnInfoModelClicked(idUser))
            }
        )
    }
}


