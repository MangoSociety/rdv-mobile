package ui.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackCallback
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import kotlinx.serialization.Serializable
import ui.auth.signin.DefaultSignInComponent
import ui.auth.signin.SignInComponent
import ui.auth.signup.DefaultSignUpComponent
import ui.auth.signup.SignUpComponent
import ui.chat.main.ChatMainComponent
import ui.chat.main.DefaultChatMainComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
): RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val backCallback = BackCallback { navigation.pop() }

    init {
        backHandler.register(backCallback)
    }

    override val stack: Value<ChildStack<*, RootComponent.Child>>
        get() = childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.ChatMain,
            childFactory = ::child
        )

    private fun child(config: Config, childComponentContext: ComponentContext): RootComponent.Child =
        when(config) {
            is Config.SignIn -> RootComponent.Child.SignIn(signInComponent(childComponentContext))
            is Config.SignUp -> RootComponent.Child.SignUp(signUpComponent(childComponentContext))
            is Config.ChatMain -> RootComponent.Child.ChatMain(chatMainComponent(childComponentContext))
        }

    private fun signInComponent(componentContext: ComponentContext): SignInComponent =
        DefaultSignInComponent(
            componentContext = componentContext,
            storeFactory = DefaultStoreFactory(),
            toSignUpRoot = ::toSignUp
        )

    private fun signUpComponent(componentContext: ComponentContext): SignUpComponent =
        DefaultSignUpComponent(
            componentContext = componentContext,
            storeFactory = DefaultStoreFactory()
        )

    private fun chatMainComponent(componentContext: ComponentContext): ChatMainComponent =
        DefaultChatMainComponent(
            componentContext = componentContext,
            storeFactory = DefaultStoreFactory(),
            toChatMainRoot = {}
        )

    override fun toSignUp() {

        navigation.push(Config.SignUp)
    }

    @Serializable
    private sealed class Config {

        @Serializable
        data object SignIn : Config()

        @Serializable
        data object SignUp : Config()

        @Serializable
        data object ChatMain : Config()

    }

}