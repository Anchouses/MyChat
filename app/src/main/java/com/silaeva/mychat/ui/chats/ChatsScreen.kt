package com.silaeva.mychat.ui.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.Colors
import com.silaeva.mychat.ui.ui_elements.SearchTextField
import com.silaeva.mychat.ui.ui_elements.Typography.title_3
import com.silaeva.mychat.ui.ui_elements.Typography.title_4
import com.silaeva.mychat.ui.ui_elements.Typography.title_9


@Composable
fun ChatScreen(){

    val viewModel = ChatsViewModel()

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val elementWidth = with(LocalDensity.current) {
        ((screenWidth.dp - dimensionResource(id = R.dimen.chat_image_diameter) -
                dimensionResource(id = R.dimen.common_margin_small) -
                dimensionResource(id = R.dimen.common_margin_small) -
                dimensionResource(id = R.dimen.categories_custom_margin) -
                dimensionResource(id = R.dimen.radius_search)))
    }
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val elementHeight =
        with(LocalDensity.current) { (screenHeight.dp - dimensionResource(id = R.dimen.nav_bar_height)) }

    val list by viewModel.list.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(elementHeight),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.common_margin_tiny))
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.common_margin_middle)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.chats),
                style = title_3
            )
        }

        SearchTextField(
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.common_margin_middle)),
            hint = stringResource(id = R.string.search_by_chats),
            getResult = {}
        )

        LazyColumn(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.common_margin_small))
        ) {

            items(list) { item ->
                Row(
                    modifier = Modifier
                        .padding(bottom = dimensionResource(id = R.dimen.common_margin_middle))
                        .fillMaxWidth()
                        .background(
                            color = Colors.white,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.common_radius_small))
                        )
                        .clickable { },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        modifier = Modifier
                            .padding(end = dimensionResource(id = R.dimen.radius_search))
                            .clip(shape = CircleShape)
                            .size(dimensionResource(id = R.dimen.chat_image_diameter)),
                        painter = painterResource(id = item.image),
                        contentDescription = stringResource(id = R.string.photos)
                    )
                    Column(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.chat_image_diameter))
                            .width(elementWidth),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.name,
                            style = title_4
                        )
                        Text(
                            text = item.authorLastMsg,
                            style = title_4
                        )
                        Text(
                            text = item.lastMsg,
                            style = title_4,
                            color = Colors.darkGrey
                        )
                    }
                    Column(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.chat_image_diameter))
                            .width(dimensionResource(id = R.dimen.categories_custom_margin)),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.date,
                            style = title_9
                        )
                        if (item.isNewMassage) {
                            val countColor = if (item.isMute) Colors.darkGrey else Colors.pink
                            Box(
                                modifier = Modifier
                                    .padding(bottom = dimensionResource(id = R.dimen.radius_search))
                                    .size(dimensionResource(id = R.dimen.common_margin_large))
                                    .background(
                                        color = countColor,
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(dimensionResource(id = R.dimen.common_margin_extra_tiny)),
                                    text = item.newMsgCount.toString(),
                                    style = title_9,
                                    color = Colors.white
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChtScrn() {
    ChatScreen()
}