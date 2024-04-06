package ui.auth.signup.store

import com.arkivanov.mvikotlin.core.store.Store

interface SignUpStore : Store<SignUpStore.Intent, SignUpStore.State, Nothing> {

    data class State(
        val success: Boolean
    )

    sealed interface Intent {

    }

    sealed interface Message {

    }

}