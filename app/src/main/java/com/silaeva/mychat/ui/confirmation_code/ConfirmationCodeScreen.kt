package com.silaeva.mychat.ui.confirmation_code

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.mychat.ui.ui_elements.ChatTopButton
import com.silaeva.mychat.ui.ui_elements.CodeInputField

@Composable
fun ConfirmationCodeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ChatTopButton(
            title = "",
            onBackClick = { /*TODO*/ },
            onInformButtonClick = {}
        )
        Text(
            text = "Введите код"
        )
        CodeInputField()
    }

}

@Preview(showBackground = true)
@Composable
fun CCS(){
    ConfirmationCodeScreen()
}