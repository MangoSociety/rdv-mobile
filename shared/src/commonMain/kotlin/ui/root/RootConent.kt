package ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import ui.auth.signin.SignInScreen

@Composable
fun RootContentShared(component: RootComponent) {
    Children(
        stack = component.stack,
        animation = stackAnimation(fade())
    ) {
        when(val child = it.instance) {
            is RootComponent.Child.SignIn -> SignInScreen(child.component)
        }
    }
}