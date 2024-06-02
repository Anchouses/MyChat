package com.silaeva.mychat.ui.ui_elements

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.silaeva.mychat.ui.ui_elements.Colors.black


object Typography {
    val title_1 = TextStyle(  //App name, section names
        fontSize = 32.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight(700),
        color = black,
        textAlign = TextAlign.Center
    )
    val title_2 = TextStyle(  //User's names, activities titles
        fontSize = 22.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight(700),
        color = black
    )
    val title_3 = TextStyle(  //Onboarding text
        fontSize = 17.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        color = black,
        textAlign = TextAlign.Center
    )

    val title_4 = TextStyle(  //Big buttons
        fontSize = 16.sp,
        lineHeight = 19.sp,
        fontWeight = FontWeight(600)
    )

    val title_5 = TextStyle(  //Inputs
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(700)
    )

    val title_6 = TextStyle(  //Small buttons
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(600)
    )

    val title_7 = TextStyle(  //Onboarding text
        fontSize = 17.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        color = black,
        textAlign = TextAlign.Center
    )

    val title_8 = TextStyle(  //Navigation bar text
        fontSize = 10.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight(500),
        color = black,
        textAlign = TextAlign.Center
    )

    val title_9 = TextStyle(  //photo page number
        fontSize = 12.sp,
        lineHeight = 14.sp,
        fontWeight = FontWeight(700),
        color = black,
        textAlign = TextAlign.Center
    )

    val title_10 = TextStyle(  //chat text
        fontSize = 16.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(400),
        color = black,
        textAlign = TextAlign.Center
    )

    val title_11 = TextStyle(  //chat names
        fontSize = 13.sp,
        lineHeight = 15.sp,
        fontWeight = FontWeight(700),
        color = black,
        textAlign = TextAlign.Center
    )
}