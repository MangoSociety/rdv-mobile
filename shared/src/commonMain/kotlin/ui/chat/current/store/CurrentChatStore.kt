package ui.chat.current.store

import com.arkivanov.mvikotlin.core.store.Store

interface CurrentChatStore : Store<CurrentChatStore.Intent, CurrentChatStore.State, Nothing> {

    data class State(
        val success: Boolean = false,
        val message: List<String> = emptyList(),
        val events: List<Event> = emptyList()
    ) {
        sealed class Event {
            data class ShowText(val text: String): Event()
        }

    }

    sealed interface Intent {
        object SendEmoji: Intent

        object BackButton: Intent

        data class OnInfoModelClicked(val chatId: Int): Intent

        data class SendMessage(val message: String): Intent
    }

    sealed interface Message {
        data object IncorrectData : Message
        data class ShowText(val text: String): Message
        data class UpdateChats(val data: List<String>): Message
    }
}