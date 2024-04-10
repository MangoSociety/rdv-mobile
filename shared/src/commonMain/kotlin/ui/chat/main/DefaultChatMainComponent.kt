package ui.chat.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import ui.auth.signin.store.SignInStore
import ui.auth.signin.store.SignInStoreFactory
import ui.chat.main.store.ChatMainStore
import ui.chat.main.store.ChatMainStoreFactory

class DefaultChatMainComponent (
    storeFactory: StoreFactory,
    componentContext: ComponentContext,
    private val toChatMainRoot: () -> Unit
) : ChatMainComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        ChatMainStoreFactory(
            storeFactory = storeFactory
        ).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<ChatMainStore.State> = store.stateFlow

    override fun onIntent(event: ChatMainStore.Intent) {
        store.accept(event)
    }

}