package ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import ui.auth.signin.SignInScreen
import ui.auth.signup.SignUpScreen
import ui.chat.main.ChatMainScreen

@Composable
fun RootContentShared(component: RootComponent) {
    Children(
        stack = component.stack,
        animation = stackAnimation(fade())
    ) {
        when(val child = it.instance) {
            is RootComponent.Child.SignIn -> SignInScreen(child.component)
            is RootComponent.Child.SignUp -> SignUpScreen(child.component)
            is RootComponent.Child.ChatMain -> ChatMainScreen(child.component)
        }
    }
}