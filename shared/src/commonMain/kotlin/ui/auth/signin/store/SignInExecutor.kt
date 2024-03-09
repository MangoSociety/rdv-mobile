package ui.auth.signin.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import ui.auth.signin.store.SignInStore.Intent
import ui.auth.signin.store.SignInStore.State
import ui.auth.signin.store.SignInStore.Message

class SignInExecutor(
    val database: String
) : CoroutineExecutor<Intent, Unit, State, Message, Nothing>() {
    override fun executeIntent(intent: Intent, getState: () -> State) {
        when (intent) {
            is Intent.SignInProcess -> signInProcess(intent.login, intent.password)
        }
    }

    private fun signInProcess(login: String, password: String) {
        dispatch(Message.SignInDone)
    }
}
