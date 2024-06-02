package com.silaeva.mychat.ui.ui_elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silaeva.mychat.R

@Composable
fun CodeInputField(){
    val text = remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .size(44.dp)
                .padding(dimensionResource(id = R.dimen.common_margin_tiny))
                .background(
                    color = Colors.white,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_search))
                )
        )
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .size(44.dp)
                .padding(dimensionResource(id = R.dimen.common_margin_tiny))
                .background(
                    color = Colors.white,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_search))
                )
        )
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .size(44.dp)
                .padding(dimensionResource(id = R.dimen.common_margin_tiny))
                .background(
                    color = Colors.white,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_search))
                )
        )
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .size(44.dp)
                .padding(dimensionResource(id = R.dimen.common_margin_tiny))
                .background(
                    color = Colors.white,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_search))
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CdInF(){
    CodeInputField()
}