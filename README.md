This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.

## Использование ресурсов

- Добавить ресурсы в папку `shared/commonMain/composeResources`
  - Строки добавляются в `values/strings.xml` по шаблону `<string name="questioning_header">Анкета</string>`
  - Изображения добавляются в `drawable`
    - Только текущая реализация поддерживает растровые изображения (png, webp, jpeg)
- Используем как
  - stringResource(Res.string.(string_name))
  - painterResource(Res.drawable.(drawable_name_without_type))
- Важно помнить, что сразу после добавления не будет доступа к ресурсам через `Res.string/drawable`, для того чтобы все работало надо собрать проект, так как оно работает через кодогенерацию     

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
