package com.mijaz.hangman.ui.hangman

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.game_fragment.*

import com.mijaz.hangman.R
import kotlinx.android.synthetic.main.fragment_settings.*

class GameFragment : Fragment() {
    private val vm: GameViewModel by navGraphViewModels(R.id.nav_graph)

    companion object {
        fun newInstance() = GameFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.word.observe(viewLifecycleOwner, Observer {
            word_textView.text = it
        })
        gameOver_button.setOnClickListener {
            val userSol = usertry_editText.getText()
            if (userSol == vm.solution) {
                Toast.makeText(activity, "Correct Answer", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(activity, vm.solution as? String, Toast.LENGTH_LONG).show()
            }
            view.findNavController().navigate(R.id.GameToResult)
            vm.word.removeObservers(viewLifecycleOwner)
            vm.newWord()
        }

    }

}
