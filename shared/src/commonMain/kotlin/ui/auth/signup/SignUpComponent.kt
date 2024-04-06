package ui.auth.signup

import kotlinx.coroutines.flow.StateFlow
import ui.auth.signup.store.SignUpStore

interface SignUpComponent {

    val state: StateFlow<SignUpStore.State>

    fun onIntent(event: SignUpStore.Intent)

}