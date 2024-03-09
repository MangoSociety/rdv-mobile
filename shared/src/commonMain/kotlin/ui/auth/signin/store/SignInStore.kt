package ui.auth.signin.store

import com.arkivanov.mvikotlin.core.store.Store
import ui.auth.signin.store.SignInStore.Intent
import ui.auth.signin.store.SignInStore.State

interface SignInStore : Store<Intent, State, Nothing> {
    data class State(
        val success: Boolean
    )

    sealed interface Intent {
        class SignInProcess(val login: String, val password: String) : Intent
    }

    sealed interface Message {
        data object IncorrectData : Message
        data object SignInDone : Message
    }

}
