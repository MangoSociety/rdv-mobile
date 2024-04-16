package ui.chat.main


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