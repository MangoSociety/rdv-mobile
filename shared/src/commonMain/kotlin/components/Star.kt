package components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

data class Star(
    val widthLine: Dp,
    val koefLine: Float,
    val koefStar: Float,
    val color: Color,
    val sizeStar: Dp,
    val heightStar: Dp,
)


@Composable
fun StarAndStick(
    modifier: Modifier,
    star: Star
) {
    Canvas(modifier = modifier.width(star.sizeStar)) {
        // Define the properties of the stick and star
        val stickWidth = 2.5f
        val stickHeight = star.heightStar * star.koefLine
        val starSize = size.width * star.koefStar // Modify this to change the size of the star
        val starCenter = Offset(size.width / 2, stickHeight.value + starSize / 2)

        val diff = 10f
        val diffWidth = 6f
        val diffSmall = 5f
        val starSizeOff = size.width * star.koefStar // Modify this to change the size of the star
        val starCenterOff = Offset(size.width / 2 + diff, stickHeight.value + starSize / 2 + diffWidth)

        drawLine(
            color = Color(0xFF101010),
            start = Offset(size.width / 2 + diffSmall, 0f + diffSmall),
            end = Offset(size.width / 2 + diffSmall, stickHeight.value + diffSmall),
            alpha = 0.1f,
            strokeWidth = stickWidth
        )

        // Draw the stick
        drawLine(
            color = Color(0xFFF1EAFF),
            start = Offset(size.width / 2, 0f),
            end = Offset(size.width / 2, stickHeight.value),
            strokeWidth = stickWidth
        )
        drawPath(
                path = createStarPath(starCenterOff, starSizeOff).first,
                color = Color(0xFF101010),
                style = Fill,
                alpha = 0.1f,
                blendMode = BlendMode.SrcOver
        )

        // Draw the star on top of the shadow
        drawPath(
            path = createStarPath(starCenter, starSize).first,
            color = star.color
        )


    }
}

// Function to create the path for a star shape
fun createStarPath(center: Offset, size: Float): Pair<Path, List<Pair<Float, Float>>> {
    val data = mutableListOf<Pair<Float, Float>>()
    val path = Path().apply {
        val outerRadius = size / 2
        val innerRadius = outerRadius / 2.5f
        val angleIncrement = 360f / 10
        var currentAngle = -90f
        for (i in 0 until 10) {
            val radius = if (i % 2 == 0) outerRadius else innerRadius
            val x = center.x + cos(toRadians(currentAngle.toDouble())) * radius
            val y = center.y + sin(toRadians(currentAngle.toDouble())) * radius
            if (i == 0) {
                moveTo(x.toFloat(), y.toFloat())
            } else {
                lineTo(x.toFloat(), y.toFloat())
                data.add(x.toFloat() to y.toFloat())
            }
            currentAngle += angleIncrement
        }
        close()
    }
    return Pair(path, data)
}

private fun toRadians(angdeg: Double): Double {
    return angdeg * 0.017453292519943295
}