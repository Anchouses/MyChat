package com.silaeva.mychat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.silaeva.mychat.ui.ui_elements.CloseActivityListener
import com.silaeva.mychat.ui.chat.ChatScreen

class MainActivity : ComponentActivity(), CloseActivityListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatScreen(closeActivityListener = this)
        }
    }

    override fun onCloseActivity() {
        finish()
    }

    private fun initUser() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID)
    }
}