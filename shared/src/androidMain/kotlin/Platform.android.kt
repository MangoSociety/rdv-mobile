import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import com.belovedev.rdv.shared.R
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual object PainterRes {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    actual fun loginBackground(): Painter = androidx.compose.ui.res.painterResource(R.drawable._ic_back)
}

actual object StringRes {
    @Composable
    actual fun registrationString() = stringResource(R.string.registratino_title)
}