package ui.chat.main


data class TemporaryUserData(
val id: Int,
val chat: Boolean,
val name: String,
val photoUrl: String,
val birthDate: Boolean,
val gender: Gender,
val lastMessage: String,
val isTyping: Boolean
)

enum class Gender {
    MALE, FEMALE, OTHER
}

fun Users():List<TemporaryUserData> {
    return listOf(
        TemporaryUserData(1, false,"Мия Мирная", "https://i.pinimg.com/236x/b3/a6/32/b3a632a5547d22c553075514add449db.jpg", true, Gender.FEMALE, "Hello!", false),
        TemporaryUserData(2, false,"Валера Митин", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbigpicture.ru%2F100-luchshix-foto-bez-fotoshopa%2F&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABAZ", false, Gender.MALE, "How are you?", true),
        TemporaryUserData(3, false,"Катерина Маркова", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.it%2Fpin%2F685039793313008761%2F&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABAR", true, Gender.FEMALE, "I'm fine, thank you.", false),
        TemporaryUserData(4, true,"Мечта", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.canva.com%2Fru_ru%2Fobuchenie%2Ffotografii-prirody-50-sovetov%2F&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABAE", false, Gender.OTHER, "Ok", true),
        TemporaryUserData(5, true, "Криминал", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fiz.ru%2F1413222%2Fgallery%2Fcomedy-wildlife-photo-awards-2022-short-list-s-finalistami&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABBB", true, Gender.OTHER, "thank you.", false),
        TemporaryUserData(6, false,"Олег Дан", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fstyle.rbc.ru%2Frepost%2F5f9936739a7947b845aaf29f&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABAp", false, Gender.MALE, "I", true),
        TemporaryUserData(7, false,"Мира Каленкова", "https://www.google.com/url?sa=i&url=https%3A%2F%2Finstalook.ru%2Fblog%2Fidei-dlya-fotosessii-na-more&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABAh", false, Gender.FEMALE, "Love you.", false),
        TemporaryUserData(8, true,"Друзьяшки", "https://www.google.com/url?sa=i&url=https%3A%2F%2Flifehacker.ru%2Fspecial%2Ffujifilm%2Fugaday-chto-na-foto%2F&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABBR", false, Gender.OTHER, "Yes", false),
        TemporaryUserData(9, false,"Нора Римова", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fural.aif.ru%2Fsociety%2Ffoto_na_pasport_kak_nakrasitsya_dlya_fotografii_na_dokumenty&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABBJ", false, Gender.FEMALE, "I'm fine)", true),
        TemporaryUserData(10, false,"Ника Авербенова", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.biletik.aero%2Fhandbook%2Fblog%2Fputeshestvuem-na-more%2Fkreativnye-idei-dlya-foto-na-more%2F&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABA5", false, Gender.FEMALE, "Nice", false),
        TemporaryUserData(11, false,"Саша Класс", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.work.ua%2Fru%2Farticles%2Fjobseeker%2F579%2F&psig=AOvVaw15OVjc3mqub2ZnNyz3ph-E&ust=1712750659356000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPDHxsiLtYUDFQAAAAAdAAAAABAx", false, Gender.MALE, "See you later!", false)
    )
}