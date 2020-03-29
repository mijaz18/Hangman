package com.mijaz.hangman.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_welcome.*
import androidx.navigation.findNavController
import com.mijaz.hangman.R

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settings_button.setOnClickListener {
            view.findNavController().navigate(R.id.WelcomeToSettings)
        }
        config_button.setOnClickListener {
            view.findNavController().navigate(R.id.WelcomeToConfig)
        }
    }

}
