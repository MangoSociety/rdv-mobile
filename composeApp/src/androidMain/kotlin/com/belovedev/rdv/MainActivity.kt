package com.belovedev.rdv

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import ui.root.DefaultRootComponent
import ui.root.RootContentShared

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = DefaultRootComponent(
            componentContext = defaultComponentContext(),
            storeFactory = DefaultStoreFactory()
        )

        setContent {
//            App()
            RootContentShared(component = rootComponent)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}