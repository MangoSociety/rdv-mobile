package ui.chat.main.store

import com.arkivanov.mvikotlin.core.store.Store

interface ChatMainStore : Store<ChatMainStore.Intent, ChatMainStore.State, Nothing> {
    data class State(
        val success: Boolean = false,
        val chats: List<String> = emptyList(),
        val events: List<Event> = emptyList()
    ) {
        sealed class Event {
            data class ShowText(val text: String): Event()
        }

    }

    sealed interface Intent {
        object OnSupportClicked: Intent

        data class OnChatClicked(val chatId: Int): Intent

        data class ProcessingSearch(val serch: String): Intent
    }

    sealed interface Message {
        data object IncorrectData : Message
        data class ShowText(val text: String): Message
        data class UpdateChats(val data: List<String>): Message
    }

}