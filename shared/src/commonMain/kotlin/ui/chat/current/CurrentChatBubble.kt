package ui.chat.current

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ChatBubble(message: String, idUser: Int, avatar: String?) {

    Box(modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        var xOffset: Dp
        var yOffset: Dp
        var xOffsetBox: Dp
        var alignment: Alignment
        var colorBack: Color
        if (idUser == 1) {
            xOffset = -4.dp
            xOffsetBox = 0.dp
            yOffset = 28.dp
            colorBack = Color(0xFFE1D2FE)
            alignment = Alignment.TopEnd
        }
        else{
            xOffset = 48.dp
            yOffset = 18.dp
            xOffsetBox = 0.dp
            colorBack = Color(0xFFFAF7FF)
            alignment = Alignment.TopStart
            avatar?.let {
                AsyncImage(
                    model = avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .align(Alignment.CenterStart),
                    contentScale = ContentScale.Crop
                )
                xOffsetBox = 52.dp
                yOffset = 28.dp
            }
        }
        // Стилизация основного баллона
        Box(
            modifier = Modifier
                .offset(x=xOffsetBox)
                .clip(RoundedCornerShape(8.dp))
                .background(colorBack)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(alignment)
        ) {
            Text(
                text = message,
                color = Color(0xFF594888)
            )
        }
        // Рисование "хвостика" баллона
        Canvas(
            modifier = Modifier
                .padding(start = 8.dp,)
                .offset(x=xOffset, y = yOffset)// Регулируйте позиционирование хвостика
                .size(12.dp, 12.dp)
                .align(alignment)
        ) {
            val path = Path().apply {
                moveTo(x = 0f, y = 0f) // Начальная точка
                lineTo(x = size.width, y = 0f) // Верхняя точка треугольника
                lineTo(x = size.width / 2, y = size.height) // Нижняя центральная точка
                close() // Замыкает путь
            }
            drawPath(
                path = path,
                color = colorBack// Цвет треугольника
            )
        }
    }
}