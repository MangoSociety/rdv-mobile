package ui.chat.main


data class TemporaryUserData(
val id: Int,
val chat: Boolean,
val name: String,
val photoUrl: String,
val birthDate: Boolean,
val gender: Gender,
val lastMessage: String,
val unReadMessage: Boolean,
val isTyping: Boolean
)

enum class Gender {
    MALE, FEMALE, OTHER
}

fun Users():List<TemporaryUserData> {
    return mutableListOf(
        TemporaryUserData(1, false,"Мия Мирная", "https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg", true, Gender.FEMALE, "Hello!", false,false),
        TemporaryUserData(2, false,"Валера Митин", "https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29.jpg", false, Gender.MALE, "How are you?", false,true),
        TemporaryUserData(3, false,"Катерина Маркова", "https://i.pinimg.com/736x/90/e8/8b/90e88b64532e96aea2d3fc5e56fa87a6.jpg", true, Gender.FEMALE, "I'm fine, thank you.", true,false),
        TemporaryUserData(4, true,"Мечта", "https://kartinki.pics/uploads/posts/2022-03/1646810804_1-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-1.jpg", false, Gender.OTHER, "Ok", true,true),
        TemporaryUserData(5, true, "Криминал", "https://cdn.iz.ru/sites/default/files/styles/2048x1365/public/photo_item-2022-10/1666271042.jpg?itok=ED-5Aq7b", false, Gender.OTHER, "thank you.", false,false),
        TemporaryUserData(6, false,"Олег Дан", "https://s0.rbk.ru/v6_top_pics/resized/1200xH/media/img/5/46/756038770746465.jpg", false, Gender.MALE, "I", false,true),
        TemporaryUserData(7, false,"Мира Каленкова", "https://instalook.ru/uploads/news/thumbs/idei-dlya-fotosessii-na-more_300x300.jpg", false, Gender.FEMALE, "Love you.", true,false),
        TemporaryUserData(8, true,"Друзьяшки", "https://instalook.ru/uploads/news/2022/082022/svadebnaja-fotosessiya-na-more.jpg", false, Gender.OTHER, "Yes", true,false),
        TemporaryUserData(9, false,"Нора Римова", "https://instalook.ru/uploads/news/2022/082022/kak-krasivo-pozirovat-na-supe.jpg", false, Gender.FEMALE, "I'm fine)", true,true),
        TemporaryUserData(10, false,"Ника Авербенова", "https://instalook.ru/uploads/news/2022/082022/follow-me-na-more.jpg", true, Gender.FEMALE, "Nice", false,false),
        TemporaryUserData(11, false,"Саша Класс", "https://kartinki.pics/uploads/posts/2022-03/1646810863_2-kartinkin-net-p-ochen-krasivie-i-neobichnie-kartinki-2.jpg", false, Gender.MALE, "See you later!", false,false)
    )
}