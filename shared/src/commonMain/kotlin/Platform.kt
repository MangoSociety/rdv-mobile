import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect object PainterRes {
    @Composable
    fun loginBackground(): Painter
}

expect object StringRes {
    @Composable
    fun registrationString(): String
}