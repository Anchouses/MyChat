package com.silaeva.mychat.ui.chats

import androidx.lifecycle.ViewModel
import com.silaeva.mychat.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatsViewModel : ViewModel() {
    private val _list = MutableStateFlow(getChatsList())
    val list = _list.asStateFlow()
    private val chatsList = ChatsList()

    private fun getChatsList(): List<ChatUIModel> {
        return chatsList.list.map { chat ->
            ChatUIModel(
                name = chat.name,
                image = chat.image,
                lastMsg = chat.lastMsg,
                authorLastMsg = chat.authorLastMsg,
                date = chat.date,
                isNewMassage = chat.isNewMassage,
                newMsgCount = chat.newMsgCount
            )
        }
    }
}

class ChatsList {
    val list = listOf<Chat>(
        Chat("Тех.поддержка", R.drawable.bottom_nav_search, "Я возьму зонтик", "Ирина", "17 мая", false, 0),
        Chat("Игорь Немцов", R.drawable.bottom_nav_search, "Я возьму зонтик", "Ирина", "17 мая", true, 3),
        Chat("Прогулка с доберманом", R.drawable.bottom_nav_search, "Я возьму зонтик", "Ирина", "17 мая", true, 1),
        Chat("Футбол", R.drawable.bottom_nav_search, "Я возьму зонтик", "Ирина", "17 мая", true, 1),
        Chat("Поход в горы", R.drawable.bottom_nav_search, "Я возьму зонтик", "Ирина", "17 мая", false, 0),
        Chat("Выставка", R.drawable.bottom_nav_search, "Я возьму зонтик", "Ирина", "17 мая", true, 5)
    )
}

data class Chat(
    val name: String,
    val image: Int,
    val lastMsg: String,
    val authorLastMsg: String,
    val date: String,
    val isNewMassage: Boolean,
    val newMsgCount: Int
)

data class ChatUIModel(
    val name: String,
    val image: Int,
    val lastMsg: String,
    val authorLastMsg: String,
    val date: String,
    val isNewMassage: Boolean,
    val newMsgCount: Int,
    val isMute: Boolean = false,
    val isPinned: Boolean = false
)
