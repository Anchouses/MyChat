package com.silaeva.mychat.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import com.silaeva.mychat.databinding.FragmentComposableBinding


abstract class ComposableFragment : Fragment() {

    private lateinit var binding: FragmentComposableBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComposableBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setContent {
            MaterialTheme {
                SetContent()
            }
        }
    }

    @Composable
    abstract fun SetContent()
}
