package com.silaeva.mychat.ui.ui_elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.mychat.R
import com.silaeva.mychat.ui.ui_elements.Typography.title_3


@Composable
fun ChatTopButton(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit,
    isFavorite: Boolean = false,
    onInformButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.top_button_height)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onBackClick() }
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(id = R.string.arrow_back),
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(isFavorite) {
                Image(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.common_margin_extra_tiny)),
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = stringResource(id = R.string.favorite),
                )
            }
            Text(
                text = title,
                style = title_3
            )
        }
        IconButton(
            onClick = { onInformButtonClick() }
        ){
            Icon(
                painter = painterResource(id = R.drawable.inform_btn_icon),
                contentDescription = stringResource(id = R.string.information)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChtTopBot() {
    ChatTopButton(
        title = stringResource(id = R.string.registration),
        onBackClick = {},
        isFavorite = true,
        onInformButtonClick = {}
    )
}