import kotlinx.coroutines.CoroutineDispatcher

interface RDVCoroutineDispatcher {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val rdvDispatcher: RDVCoroutineDispatcher