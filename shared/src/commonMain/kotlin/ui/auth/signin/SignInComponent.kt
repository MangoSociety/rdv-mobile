package ui.auth.signin

import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import ui.auth.signin.store.SignInStore

interface SignInComponent {

    val state: StateFlow<SignInStore.State>

    fun onIntent(event: SignInStore.Intent)

    fun toSignUp()
}