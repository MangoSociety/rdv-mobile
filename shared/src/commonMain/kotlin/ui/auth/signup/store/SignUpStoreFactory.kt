package ui.auth.signup.store

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create

class SignUpStoreFactory(private val storeFactory: StoreFactory) {

    fun create(): SignUpStore {
        return SignUpStoreImpl()
    }

    private inner class SignUpStoreImpl : SignUpStore, Store<SignUpStore.Intent, SignUpStore.State, Nothing> by storeFactory.create(
        name = "SignUpStore",
        initialState = SignUpStore.State(false),
        executorFactory = { SignUpExecutor() },
        reducer = SignUpReducer
    )

}