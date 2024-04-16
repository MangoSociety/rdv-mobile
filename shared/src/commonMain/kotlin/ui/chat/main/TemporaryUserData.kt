package ui.chat.main


/*
* Описание показа чатов
* - выводим все элементы с типом Chat
* - наименовние это data name
* - аватар из data avatar
* - гендер ставим если type==ChatType.Self и берем из data.gender
* - текст сообщения (условие: если не data.isTyping) если (это группа ) добавляем имя автора сообщения если личка то просто сообщение
* */
data class Chat(
    val id: Int,
    val type: ChatType,
    val data: ShortUserData
)

enum class ChatType{
    GROUP, SELF
}

// минимальная инфа от юзера для отображения чата в списке
data class ShortUserData(
    val isTyping: Boolean,
    val name: String,
    val avatar: String, // link image
    val isBirthday: Boolean,
    val gender: Gender,
    val message: String,
    val isNewMessage: Boolean,
    val lastMessageName: String,
    val online: Boolean
)



enum class Gender {
    MALE, FEMALE, OTHER
}

