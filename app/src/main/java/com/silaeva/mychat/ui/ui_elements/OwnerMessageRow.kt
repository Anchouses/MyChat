package com.silaeva.mychat.ui.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.Typography.title_4
import com.silaeva.mychat.ui.ui_elements.Typography.title_9


@Composable
fun OwnerMessageRow(
    modifier: Modifier = Modifier,
    text: String,
    time: String,
    isRead: Boolean = false,
    width: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = dimensionResource(id = R.dimen.common_margin_small))
                .widthIn(min = 60.dp, max = (width * 0.8f))
                .background(
                    color = Colors.lightGrey,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.message_radius))
                ),
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.message_text_margin),
                        start = dimensionResource(id = R.dimen.message_text_margin),
                        end = dimensionResource(id = R.dimen.message_text_margin)
                    ),
                text = text,
                style = title_4,
                textAlign = TextAlign.Start
            )
            Row(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.radius_search),
                        end = dimensionResource(id = R.dimen.radius_search),
                        bottom = dimensionResource(id = R.dimen.radius_search)
                    ),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            end = dimensionResource(id = R.dimen.common_margin_extra_tiny)
                        ),
                    text = time,
                    style = title_9
                )
                if (isRead) {
                    Icon(
                        painter = painterResource(id = R.drawable.is_read_icon),
                        contentDescription = null,
                        tint = Colors.pink
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OwnrMsg() {
    OwnerMessageRow(
        text = "hiввыяваывдалдмоыдлаофлвоыдлваоыфлвоалдявыаолдыволдвыодлвыо",
        time = "22.04",
        isRead = true,
        width = 375.dp
    )
}