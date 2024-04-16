package ui.chat.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.dot
import rdv_mobile.shared.generated.resources.female_gender
import rdv_mobile.shared.generated.resources.gift
import rdv_mobile.shared.generated.resources.male_gender
import kotlin.random.Random

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ChatWithUser(
    chat: Chat,
    modifier: Modifier = Modifier,
    onChatClicked: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().clickable { onChatClicked.invoke(Random(324).nextInt()) }
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFF1EAFF),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(modifier = Modifier.size(48.dp)) {
                        AsyncImage(
                            model = chat.data.avatar,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        val genderDrawable =
                            GenderDrawable(chat.data.gender, Res.drawable.female_gender, Res.drawable.male_gender)
                        genderDrawable?.let {
                            Image(
                                painterResource(genderDrawable),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(14.dp)
                                    .offset(y = -4.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(bottom = 14.dp, start = 12.dp)) {
                        Text(
                            color = Color(0xFF594888),
                            text = chat.data.name,
                            fontSize = 14.sp
                        )
                        VisibleMessage(chat.data.message, chat.data.isTyping)
                    }
                }
                val unReadMessage = DrawingOrNo(chat.data.isNewMessage, Res.drawable.dot)
                unReadMessage?.let {
                    Image(
                        painterResource(unReadMessage),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 19.dp)
                            .size(6.dp)
                            .align(Alignment.CenterEnd)
                    )
                }
            }
        }
        val birthday = DrawingOrNo(chat.data.isBirthday, Res.drawable.gift)
        birthday?.let {
            Image(
                painterResource(birthday),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopStart)
                    .offset(x = 15.dp, y = -5.dp),
            )
        }
    }
}