package ui.chat.current

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import ui.chat.current.store.CurrentChatStore
import ui.chat.current.store.CurrentChatStoreFactory

class DefaultCurrentChatComponent (
    storeFactory: StoreFactory,
    componentContext: ComponentContext,
    private val toCurrentChatRoot: () -> Unit
) : CurrentChatComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        CurrentChatStoreFactory(
            storeFactory = storeFactory
        ).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<CurrentChatStore.State> = store.stateFlow

    override fun onIntent(event: CurrentChatStore.Intent) {
        store.accept(event)
    }

}