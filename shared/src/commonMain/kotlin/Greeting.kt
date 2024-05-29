class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Goodbye, ${platform.name}!"
    }
}