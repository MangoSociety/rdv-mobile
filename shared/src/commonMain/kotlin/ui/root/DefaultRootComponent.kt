package ui.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import kotlinx.serialization.Serializable
import ui.auth.signin.DefaultSignInComponent
import ui.auth.signin.SignInComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
): RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>>
        get() = childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.SignIn,
            childFactory = ::child
        )

    private fun child(config: Config, childComponentContext: ComponentContext): RootComponent.Child =
        when(config) {
            is Config.SignIn -> RootComponent.Child.SignIn(signInComponent(childComponentContext))
        }

    private fun signInComponent(componentContext: ComponentContext): SignInComponent =
        DefaultSignInComponent(
            componentContext = componentContext,
            storeFactory = DefaultStoreFactory()
        )

    @Serializable
    private sealed class Config {

        @Serializable
        data object SignIn : Config()

    }

}