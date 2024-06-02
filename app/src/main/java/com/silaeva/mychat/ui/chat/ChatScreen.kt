package com.silaeva.mychat.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.ChatTopButton
import com.silaeva.mychat.ui.ui_elements.CloseActivityListener
import com.silaeva.mychat.ui.ui_elements.OwnerMessageRow
import com.silaeva.mychat.ui.ui_elements.ReceivedMessageRow
import com.silaeva.mychat.ui.ui_elements.SentMessagePanel
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun ChatScreen(
    closeActivityListener: CloseActivityListener?
) {
    val viewModel: ChatViewModel = viewModel()
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val msgList = viewModel.msgList
    val text by viewModel.text.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ChatTopButton(
            title = viewModel.getName()!!,
            onBackClick = { },
            isFavorite = true,
            onInformButtonClick = {
                viewModel.signOut()
                closeActivityListener?.onCloseActivity()
            }
        )
        Column {
            LazyColumn(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.common_margin_small)),
                verticalArrangement = Arrangement.Bottom
            ) {
                items(msgList.value) { message ->
                    val sdf = remember {
                        SimpleDateFormat("hh:mm", Locale.ROOT)
                    }

                    when(true) {  //message.isMessageFromOpponent
                        true -> {
                            ReceivedMessageRow(
                                text = "message.chatMessage.message",
                                time = "sdf.format(message.chatMessage.date)",
                                width = screenWidth.dp,
                                name = "message.name"
                            )
                        }
                        false -> {
                            OwnerMessageRow(
                                text = "message.chatMessage.message",
                                time = "sdf.format(message.chatMessage.date)",
                                width = screenWidth.dp
                            )
                        }
                    }
                }
            }
        }
        SentMessagePanel(
            onSendMessage = {
                viewModel.setOwnerMsg(it)
            },
            onAttachButton = {}
        )
    }
}