package com.silaeva.mychat.ui.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.Typography.title_5
import com.silaeva.mychat.ui.ui_elements.Typography.title_6

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    hint: String,
    getResult: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val text = remember { mutableStateOf("") }
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
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Colors.extraLightGrey)
    ) {
        BasicTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                getResult(text.value)
            },
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.common_margin_small),
                    top = dimensionResource(id = R.dimen.common_margin_extra_tiny),
                    bottom = dimensionResource(id = R.dimen.common_margin_extra_tiny),
                    end = dimensionResource(id = R.dimen.common_margin_small)
                )
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.search_field_height)),
            textStyle = title_5
        ) {
            OutlinedTextFieldDefaults.DecorationBox(
                value = text.value,
                visualTransformation = VisualTransformation.None,
                innerTextField = it,
                singleLine = singleLine,
                enabled = enabled,
                placeholder = {
                    Text(
                        text = hint,
                        style = title_6
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.bottom_nav_search),
                        contentDescription = null,
                        tint = Colors.grey
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.cancel_icon),
                        contentDescription = null,
                        tint = Colors.darkGrey,
                        modifier = Modifier.clickable {
                            text.value = ""
                        }
                    )
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
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_search))
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SrchInput() {
    SearchTextField(
        modifier = Modifier,
        hint = (stringResource(id = R.string.search)),
        getResult = {}
    )
}