package ui.chat.main.store

import com.arkivanov.mvikotlin.core.store.Reducer
import ui.auth.signin.store.SignInStore

object ChatMainReducer : Reducer<ChatMainStore.State, ChatMainStore.Message> {
    override fun ChatMainStore.State.reduce(msg: ChatMainStore.Message): ChatMainStore.State {
        return when (msg) {
            ChatMainStore.Message.IncorrectData -> TODO()
            is ChatMainStore.Message.ShowText -> {
                copy(
                    events = events + ChatMainStore.State.Event.ShowText(msg.text)
                )
            }
            is ChatMainStore.Message.UpdateChats -> {
                copy(
                    chats = msg.data
                )
            }
        }
    }


}