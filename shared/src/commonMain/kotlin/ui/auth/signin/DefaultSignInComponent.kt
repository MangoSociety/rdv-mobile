package ui.auth.signin

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import ui.auth.signin.store.SignInStoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import kotlinx.coroutines.flow.Flow
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.arkivanov.mvikotlin.extensions.coroutines.states
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ui.auth.signin.store.SignInStore

class DefaultSignInComponent(
    storeFactory: StoreFactory,
    componentContext: ComponentContext
) : SignInComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        SignInStoreFactory(
            storeFactory = storeFactory
        ).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<SignInStore.State> = store.stateFlow

    override fun onIntent(event: SignInStore.Intent) {
        store.accept(event)
    }

}
