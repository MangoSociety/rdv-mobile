package ui.chat.current.store

import com.arkivanov.mvikotlin.core.store.Reducer

object CurrentChatReducer : Reducer<CurrentChatStore.State, CurrentChatStore.Message> {
    override fun CurrentChatStore.State.reduce(msg: CurrentChatStore.Message): CurrentChatStore.State {
        return when (msg) {
            CurrentChatStore.Message.IncorrectData -> TODO()
            is CurrentChatStore.Message.ShowText -> {
                copy(
                    events = events + CurrentChatStore.State.Event.ShowText(msg.text)
                )
            }
            is CurrentChatStore.Message.UpdateChats -> {
                copy(
                    message = msg.data
                )
            }
        }
    }
}