package ui.chat.current

import BackgroundColor
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ui.chat.current.store.CurrentChatStore

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


