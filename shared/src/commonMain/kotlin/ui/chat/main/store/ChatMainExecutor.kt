package ui.chat.main.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

class ChatMainExecutor() :
    CoroutineExecutor<ChatMainStore.Intent, Unit, ChatMainStore.State, ChatMainStore.Message, Nothing>() {

        private val searchFlow = MutableStateFlow("")

    override fun executeIntent(intent: ChatMainStore.Intent, getState: () -> ChatMainStore.State) {
        when (intent) {
            is ChatMainStore.Intent.OnChatClicked -> {
                val message = ChatMainStore.Message.ShowText("click by chat")
                dispatch(message)
            }

            ChatMainStore.Intent.OnSupportClicked -> {
                val message = ChatMainStore.Message.ShowText("click by support")
                dispatch(message)
            }

            is ChatMainStore.Intent.ProcessingSearch -> {
                searchFlow.tryEmit(intent.serch)
            }
        }
    }

    private suspend fun searchCollect() {
        searchFlow
            .debounce(300)
            .filter { it.length > 1 }
            .distinctUntilChanged()
            .collectLatest {  query ->
                val user = listOf<String>()// processing = network request for query
                dispatch(ChatMainStore.Message.UpdateChats(user))
            }
    }
}