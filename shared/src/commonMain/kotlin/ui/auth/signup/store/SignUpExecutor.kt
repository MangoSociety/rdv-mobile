package ui.auth.signup.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

class SignUpExecutor() :
    CoroutineExecutor<SignUpStore.Intent, Unit, SignUpStore.State, SignUpStore.Message, Nothing>() {

    override fun executeIntent(intent: SignUpStore.Intent, getState: () -> SignUpStore.State) {
        super.executeIntent(intent, getState)
    }

    override fun executeAction(action: Unit, getState: () -> SignUpStore.State) {
        super.executeAction(action, getState)
    }

}