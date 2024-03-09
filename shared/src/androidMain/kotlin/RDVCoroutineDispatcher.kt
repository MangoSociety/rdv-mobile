import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val rdvDispatcher: RDVCoroutineDispatcher = object: RDVCoroutineDispatcher {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main.immediate
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}