package ui.auth.signin.store

import com.arkivanov.mvikotlin.core.store.Reducer
import ui.auth.signin.store.SignInStore.State
import ui.auth.signin.store.SignInStore.Message

object SignInReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State {
        return when (msg) {
            is Message.SignInDone -> {
                copy(success = true)
            }
            else -> copy(success = false)
        }
    }


}