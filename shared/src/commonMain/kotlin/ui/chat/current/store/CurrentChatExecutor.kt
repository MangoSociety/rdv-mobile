package ui.chat.current.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.flow.MutableStateFlow

class CurrentChatExecutor() :
    CoroutineExecutor<CurrentChatStore.Intent, Unit, CurrentChatStore.State, CurrentChatStore.Message, Nothing>() {

    override fun executeIntent(intent: CurrentChatStore.Intent, getState: () -> CurrentChatStore.State) {
        when (intent) {
            is CurrentChatStore.Intent.OnInfoModelClicked -> {
                val message = CurrentChatStore.Message.ShowText("click by info model")
                dispatch(message)
            }

            CurrentChatStore.Intent.SendEmoji -> {
                val message = CurrentChatStore.Message.ShowText("click by emoji")
                dispatch(message)
            }

            CurrentChatStore.Intent.BackButton -> {
                val message = CurrentChatStore.Message.ShowText("click by back button")
                dispatch(message)
            }

            is CurrentChatStore.Intent.SendMessage -> {
                val message = CurrentChatStore.Message.ShowText("click by send message")
                dispatch(message)            }
        }
    }
}