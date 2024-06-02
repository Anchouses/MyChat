package com.silaeva.mychat.ui.chats

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.silaeva.mychat.base.ComposableFragment

class ChatsFragment : ComposableFragment() {

    companion object {
        fun newInstance() = ChatsFragment()
    }

    private val viewModel: ChatsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @Composable
    override fun SetContent() {
        TODO("Not yet implemented")
    }
}