import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import ui.root.DefaultRootComponent
import ui.root.RootContentShared

fun MainViewController() = ComposeUIViewController {

    val rootComponent = DefaultRootComponent(
        componentContext = DefaultComponentContext(LifecycleRegistry()),
        storeFactory = DefaultStoreFactory()
    )

    RootContentShared(component = rootComponent)
}