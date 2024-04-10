package ui.chat.main

import kotlinx.coroutines.flow.StateFlow
import ui.auth.signup.store.SignUpStore
import ui.chat.main.store.ChatMainStore

interface ChatMainComponent {

    val state: StateFlow<ChatMainStore.State>

    fun onIntent(event: ChatMainStore.Intent)

}