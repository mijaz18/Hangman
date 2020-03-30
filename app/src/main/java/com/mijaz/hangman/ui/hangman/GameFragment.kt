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
import android.widget.RelativeLayout
import android.graphics.Color

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        vm.word.observe(viewLifecycleOwner, Observer {
            word_textView.text = it
        })
        Toast.makeText(activity, vm.colorChange as? String, Toast.LENGTH_LONG).show()
       // gameOver_button.setBackgroundColor(Color.RED)
        if(vm.colorChange){
            gameOver_button.setBackgroundColor(Color.RED)
        }
        gameOver_button.setOnClickListener {
            val userSol = usertry_editText.getText()
            if (userSol == vm.solution) {
                Toast.makeText(activity, "You guess right!", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(activity, "You guessed wrong!", Toast.LENGTH_LONG).show()
            }
            view.findNavController().navigate(R.id.GameToResult)
            vm.word.removeObservers(viewLifecycleOwner)
            vm.newWord()
        }

    }

}
