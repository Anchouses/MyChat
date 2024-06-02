package com.silaeva.mychat.ui.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.Typography.title_10
import com.silaeva.mychat.ui.ui_elements.Typography.title_11
import com.silaeva.mychat.ui.ui_elements.Typography.title_9


@Composable
fun ReceivedMessageRow(
    name: String?,
    text: String?,
    time: String,
    width: Dp
) {
    Column(
        modifier = Modifier
            .padding(bottom = dimensionResource(id = R.dimen.common_margin_small))
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ){
            Column(
                modifier = Modifier
                    .widthIn(min = 60.dp, max = (width * 0.8f))
                    .background(
                        color = Colors.pink,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.message_radius))
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if (name != null) {
                    Text(
                        modifier = Modifier
                            .padding(
                                top = dimensionResource(id = R.dimen.radius_search),
                                start = dimensionResource(id = R.dimen.message_text_margin),
                                end = dimensionResource(id = R.dimen.message_text_margin),
                                bottom = dimensionResource(id = R.dimen.common_margin_extra_tiny)
                            ),
                        text = name,
                        style = title_11,
                        color = Colors.white
                    )
                }

                if (text != null) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.message_text_margin),
                                end = dimensionResource(id = R.dimen.message_text_margin),
                                bottom = dimensionResource(id = R.dimen.common_margin_middle)
                            ),
                        text = text,
                        style = title_10,
                        color = Colors.white,
                        textAlign = TextAlign.Start
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.radius_search),
                        end = dimensionResource(id = R.dimen.radius_search),
                        bottom = dimensionResource(id = R.dimen.common_margin_extra_tiny)
                    ),
                text = time,
                color = Colors.transparentWhite,
                style = title_9
            )
        }
    }
}

@Preview
@Composable
fun IntrLctrMsg() {
    ReceivedMessageRow(
        text = "hiввыяваывдалдмоы",
        time = "22.04",
        width = 375.dp,
        name = "Ольга николаевна"
    )
}