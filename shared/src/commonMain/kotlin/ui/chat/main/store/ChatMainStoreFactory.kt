package ui.chat.main.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ui.auth.signin.store.SignInExecutor
import ui.auth.signin.store.SignInReducer
import ui.auth.signin.store.SignInStore

class ChatMainStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): ChatMainStore {
        return ChatMainStoreImpl()
    }

    private inner class ChatMainStoreImpl :
        ChatMainStore,
        Store<ChatMainStore.Intent, ChatMainStore.State, Nothing> by storeFactory.create(
            name = "ChatMainStore",
            initialState = ChatMainStore.State(),
            executorFactory = { ChatMainExecutor() },
            reducer = ChatMainReducer
        )

}