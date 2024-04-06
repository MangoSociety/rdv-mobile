package ui.auth.signup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import ui.auth.signin.store.SignInStoreFactory
import ui.auth.signup.store.SignUpStore
import ui.auth.signup.store.SignUpStoreFactory

class DefaultSignUpComponent(
    storeFactory: StoreFactory,
    componentContext: ComponentContext
) : SignUpComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        SignUpStoreFactory(
            storeFactory = storeFactory
        ).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<SignUpStore.State> = store.stateFlow

    override fun onIntent(event: SignUpStore.Intent) {
        store.accept(event)
    }

}