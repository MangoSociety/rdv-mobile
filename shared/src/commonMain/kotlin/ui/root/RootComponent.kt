package ui.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ui.auth.signin.SignInComponent
import ui.auth.signup.SignUpComponent
import ui.chat.main.ChatMainComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        class SignIn(val component: SignInComponent): Child()
        class SignUp(val component: SignUpComponent): Child()
        class ChatMain(val component: ChatMainComponent): Child()
    }

    fun toSignUp()
}