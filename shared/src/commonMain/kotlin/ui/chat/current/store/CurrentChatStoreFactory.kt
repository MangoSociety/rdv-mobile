package ui.chat.current.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
class CurrentChatStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): CurrentChatStore {
        return CurrentChatStoreImpl()
    }

    private inner class CurrentChatStoreImpl :
        CurrentChatStore,
        Store<CurrentChatStore.Intent, CurrentChatStore.State, Nothing> by storeFactory.create(
            name = "ChatMainStore",
            initialState = CurrentChatStore.State(),
            executorFactory = { CurrentChatExecutor() },
            reducer = CurrentChatReducer
        )
}