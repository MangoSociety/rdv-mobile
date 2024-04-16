package ui.chat.main

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GenderDrawable(
    gender: Gender,
    drawingFemale: DrawableResource,
    drawingMale: DrawableResource
): DrawableResource? {
    return when (gender) {
        Gender.FEMALE -> drawingFemale
        Gender.MALE -> drawingMale
        Gender.OTHER -> null
    }
}