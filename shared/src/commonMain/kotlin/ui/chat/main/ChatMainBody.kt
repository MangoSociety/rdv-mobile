package ui.chat.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import rdv_mobile.shared.generated.resources.Res
import rdv_mobile.shared.generated.resources.chat_search
import rdv_mobile.shared.generated.resources.search
import ui.chat.main.store.ChatMainStore

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChatMainBody(component: ChatMainComponent){
    val state by component.state.collectAsState()
    val interactionSource = remember { MutableInteractionSource() }
    val message = remember { mutableStateOf("") }
    val chat = Chat()
    var resultUsers = remember { mutableStateOf(Chat()) }
    Column {
        state.events.forEach {
            when (it) {
                is ChatMainStore.State.Event.ShowText -> {
                    Text("sdfdsf", fontSize = 36.sp)
                }
            }
        }
        TextField(
            value = message.value,
            textStyle = TextStyle(color = Color(0xFF594888), fontSize = 18.sp),
            onValueChange = { newText ->
                message.value = newText
                component.onIntent(ChatMainStore.Intent.ProcessingSearch(newText))
                resultUsers.value = (chat.filter {
                    it.data.name.toLowerCase().contains(newText.toLowerCase())
                }).toMutableList()
            },
            trailingIcon = {
                Image(
                    painterResource(Res.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFFAF7FF),
                focusedContainerColor = Color(0xFFFAF7FF),
                focusedIndicatorColor = Color(0xFFFAF7FF),
                unfocusedIndicatorColor = Color(0xFFFAF7FF),
            ),
            placeholder = {
                Text(stringResource(Res.string.chat_search), color = Color(0xCC594888))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 12.dp)
                .heightIn(min = 40.dp)
                .clip(RoundedCornerShape(8.dp))
                .indicatorLine(
                    false, false,
                    interactionSource,
                    TextFieldDefaults.textFieldColors(),
                    focusedIndicatorLineThickness = 0.dp,
                    unfocusedIndicatorLineThickness = 0.dp
                )
        )
        LazyColumn(
            contentPadding = PaddingValues(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) {
            items(resultUsers.value) {
                ChatWithUser(
                    it,
                    onChatClicked = { component.onIntent(ChatMainStore.Intent.OnChatClicked(it)) })
            }
        }
    }
}
