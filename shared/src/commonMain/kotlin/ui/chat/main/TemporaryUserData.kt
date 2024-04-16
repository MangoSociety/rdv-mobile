package ui.chat.main

import androidx.compose.runtime.Composable

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


data class ChatMain(
    val id: Int,
    val info: ChatSealed,
    val messages: List<UserMessage>
)

/*
data: ChatMain
* when (data.info) {
is ChatSealed.ChatGroup -> { draw chat group}
is ChatSealed.ChatSelf -> { draw chat self}
}
* */
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
    val isTypung: Boolean,
    val online: Boolean
)


enum class Gender {
    MALE, FEMALE, OTHER
}

@Composable
fun ChatMain():List<ChatMain>{
    return mutableListOf(
        ChatMain(1,ChatSealed.ChatSelf("Мия Мирная",true,"https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg"), listOf(UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Hello!", true,true), UserMessage(2,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,true), UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Hello!", true,true), UserMessage(2,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,true), UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Hello!", true,true))),
        ChatMain(2,ChatSealed.ChatSelf("Валера Митин",false, "https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg"), listOf(UserMessage(1,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,true), UserMessage(2,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg","I'm fine, thank you.",false,false))),
        ChatMain(3,ChatSealed.ChatSelf("Катерина Маркова",false, "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg",), listOf(UserMessage(2,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,true), UserMessage(1,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg","I'm fine, thank you.",false,false))),
        ChatMain(4,ChatSealed.ChatGroup("Мечта","https://kartinki.pics/uploads/posts/2022-03/1646810804_1-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-1.jpg"), listOf(UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Hello!", true,false),UserMessage(2,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,false),UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Ok! And u?", true,true),UserMessage(3,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg","I'm fine, thank you.",false,false),UserMessage(4,"Олег Дан","https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg","I",false,false),UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Love!", true,true),UserMessage(5,"Нора Римова","https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg","I'm fine)",false,true))),
        ChatMain(5,ChatSealed.ChatGroup("Криминал","https://cdn.iz.ru/sites/default/files/styles/2048x1365/public/photo_item-2022-10/1666271042.jpg?itok=ED-5Aq7b"), listOf(UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Hello!", true,true),UserMessage(2,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,false),UserMessage(3,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg","I'm fine, thank you.",false,false),UserMessage(4,"Олег Дан","https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg","I",false,true),UserMessage(5,"Нора Римова","https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg","I'm fine)",false,true))),
        ChatMain(6,ChatSealed.ChatSelf("Олег Дан",false,"https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg"), listOf(UserMessage(1,"Олег Дан","https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg","I",false,true))),
        ChatMain(7,ChatSealed.ChatSelf("Мира Каленкова",false,"https://instalook.ru/uploads/news/thumbs/idei-dlya-fotosessii-na-more_300x300.jpg"), listOf(UserMessage(1,"Мира Каленкова","https://instalook.ru/uploads/news/thumbs/idei-dlya-fotosessii-na-more_300x300.jpg","Love you.",true,false))),
        ChatMain(8,ChatSealed.ChatGroup("Друзьяшки","https://instalook.ru/uploads/news/2022/082022/svadebnaja-fotosessiya-na-more.jpg"), listOf(UserMessage(1,"Мия Мирная","https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg","Hello!", true,true),UserMessage(2,"Валера Митин","https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg","How are you?", false,true),UserMessage(3,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg","I'm fine, thank you.",false,true),UserMessage(4,"Олег Дан","https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg","I",false,true),UserMessage(5,"Нора Римова","https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg","I'm fine)",false,false))),
        ChatMain(9,ChatSealed.ChatSelf("Нора Римова",false,"https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg"), listOf(UserMessage(1,"Нора Римова","https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg","I'm fine)",false,false))),
        ChatMain(10,ChatSealed.ChatSelf("Ника Авербенова",false,"https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg"), listOf(UserMessage(1,"Ника Авербенова","https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg","Nice",true,true))),
        ChatMain(11,ChatSealed.ChatSelf("Саша Класс",false,"https://kartinki.pics/uploads/posts/2022-03/1646810863_2-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-2.jpg"), listOf(UserMessage(1,"Саша Класс","https://kartinki.pics/uploads/posts/2022-03/1646810863_2-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-2.jpg","See you later!",false,false))),
    )
}

fun Chat():List<Chat>{
    return mutableListOf(
        Chat(1, ChatType.SELF, ShortUserData( true,"Мия Мирная", "https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg", true, Gender.FEMALE, "Hello!", false,"Мия Мирная", true)),
        Chat(2,ChatType.SELF,ShortUserData(false,"Валера Митин", "https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg", false, Gender.MALE, "How are you?", false,"Валера Митин",true)),
        Chat(3,ChatType.SELF,ShortUserData(false,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg", true, Gender.FEMALE, "I'm fine, thank you.", true,"Катерина Маркова",false)),
        Chat(4,ChatType.GROUP,ShortUserData(false,"Мечта", "https://kartinki.pics/uploads/posts/2022-03/1646810804_1-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-1.jpg", false, Gender.OTHER, "Ok", true,"Катерина Маркова",true)),
        Chat(5,ChatType.GROUP,ShortUserData(true, "Криминал", "https://cdn.iz.ru/sites/default/files/styles/2048x1365/public/photo_item-2022-10/1666271042.jpg?itok=ED-5Aq7b", false, Gender.OTHER, "thank you.", false,"Валера Митин",true)),
        Chat(6,ChatType.SELF,ShortUserData(false,"Олег Дан", "https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg", false, Gender.MALE, "I", false,"Олег Дан",true)),
        Chat(7,ChatType.SELF,ShortUserData(true,"Мира Каленкова", "https://instalook.ru/uploads/news/thumbs/idei-dlya-fotosessii-na-more_300x300.jpg", false, Gender.FEMALE, "Love you.", true,"Мира Каленкова",false)),
        Chat(8,ChatType.GROUP,ShortUserData(true,"Друзьяшки", "https://instalook.ru/uploads/news/2022/082022/svadebnaja-fotosessiya-na-more.jpg", false, Gender.OTHER, "Yes", true,"Нора Римова",true)),
        Chat(9,ChatType.SELF,ShortUserData(false,"Нора Римова", "https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg", false, Gender.FEMALE, "I'm fine)", true,"Нора Римова",false)),
        Chat(10,ChatType.SELF,ShortUserData(false,"Ника Авербенова", "https://instalook.ru/uploads/news/2022/082022/follow-me-na-more.jpg", true, Gender.FEMALE, "Nice", false,"Ника Авербенова",true)),
        Chat(11,ChatType.SELF,ShortUserData(false,"Саша Класс", "https://kartinki.pics/uploads/posts/2022-03/1646810863_2-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-2.jpg", false, Gender.MALE, "See you later!", false,"Саша Класс",false))
    )
}
