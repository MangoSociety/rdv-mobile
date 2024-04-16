package ui.chat.current

data class ChatMain(
    val id: Int,
    val info: ChatSealed,
    val messages: List<UserMessage>
)

sealed class ChatSealed(val avatarMain: String, val titleMain: String) {
    data class ChatGroup(
        val title: String,
        val avatar: String
    ): ChatSealed(avatarMain = avatar, titleMain = title)

    data class ChatSelf(
        val title: String,
        val isBirthday: Boolean,
        val avatar: String
    ) : ChatSealed(avatarMain = avatar, titleMain = title)
}

data class UserMessage(
    val id: Int,
    val name: String,
    val avatar: String,
    val message: String,
    val isTyping: Boolean,
    val online: Boolean
)
