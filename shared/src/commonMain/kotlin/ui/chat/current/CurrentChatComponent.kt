package ui.chat.current

import kotlinx.coroutines.flow.StateFlow
import ui.chat.current.store.CurrentChatStore

interface CurrentChatComponent {

    val state: StateFlow<CurrentChatStore.State>

    fun onIntent(event: CurrentChatStore.Intent)

}