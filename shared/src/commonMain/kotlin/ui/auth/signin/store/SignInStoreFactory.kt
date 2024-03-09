package ui.auth.signin.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ui.auth.signin.store.SignInStore.Intent
import ui.auth.signin.store.SignInStore.State
import ui.auth.signin.store.SignInStore.Message

class SignInStoreFactory(private val storeFactory: StoreFactory) {

    fun create(): SignInStore {
        return SignInStoreImpl()
    }

    private inner class SignInStoreImpl :
        SignInStore,
        Store<Intent, State, Nothing> by storeFactory.create(
            name = "SignInStore",
            initialState = State(false),
            executorFactory = { SignInExecutor("sign in database") },
            reducer = SignInReducer
        )

}