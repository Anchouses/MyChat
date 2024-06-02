package com.silaeva.mychat.ui.ui_elements

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.Typography.title_4


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SentMessagePanel(
    modifier: Modifier = Modifier,
    onSendMessage: (String) -> Unit,
    onAttachButton: () -> Unit
) {

    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = false

    val colors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = Colors.lightGrey,
        unfocusedContainerColor = Colors.lightGrey,
        focusedTextColor = Colors.black,
        unfocusedTextColor = Colors.black,
        focusedPlaceholderColor = Colors.grey,
        unfocusedPlaceholderColor = Colors.grey,
        focusedBorderColor = Colors.lightGrey,
        unfocusedBorderColor = Colors.lightGrey,
    )

    Column {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = dimensionResource(id = R.dimen.button_border_small),
            color = Colors.lightGrey
        )
        Row(
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.radius_search),
                    start = dimensionResource(id = R.dimen.common_margin_small),
                    end = dimensionResource(id = R.dimen.common_margin_small),
                    bottom = dimensionResource(id = R.dimen.common_margin_small)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    onAttachButton()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_attachment),
                    contentDescription = stringResource(id = R.string.attach)
                )
            }
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.common_margin_extra_tiny),
                        bottom = dimensionResource(id = R.dimen.common_margin_extra_tiny)
                    )
                    .fillMaxWidth()
                    .heightIn(
                        min = dimensionResource(id = R.dimen.message_input_height),
                        max = dimensionResource(id = R.dimen.input_description_height)
                    )
                    .weight(1f, true),
                textStyle = Typography.title_5
            ) {
                OutlinedTextFieldDefaults.DecorationBox(
                    value = text,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = it,
                    singleLine = singleLine,
                    enabled = enabled,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.message),
                            style = title_4
                        )
                    },
                    trailingIcon = {
                        TextButton(
                            onClick = {
                                onSendMessage(text)
                                text = ""
                            },
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.common_radius_large)),
                        ) {
                            Text(
                                text = stringResource(id = R.string.send),
                                style = title_4,
                                color = Colors.pink
                            )
                        }
                    },
                    interactionSource = interactionSource,
                    contentPadding = OutlinedTextFieldDefaults.contentPadding(
                        top = dimensionResource(id = R.dimen.common_margin_tiny),
                        bottom = dimensionResource(id = R.dimen.common_margin_tiny)
                    ),
                    colors = colors,
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled = enabled,
                            isError = false,
                            colors = colors,
                            interactionSource = interactionSource,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.common_radius_large))
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SndMsgPnl() {
    SentMessagePanel(
        onSendMessage = {},
        onAttachButton = {}
    )
}
