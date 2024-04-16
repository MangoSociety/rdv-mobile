package ui.chat.main

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
@Composable
fun DrawingOrNo(choise: Boolean, drawing: DrawableResource): DrawableResource? {
    return when (choise) {
        true -> drawing
        else -> null
    }
}
