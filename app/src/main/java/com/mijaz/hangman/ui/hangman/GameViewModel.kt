package com.mijaz.hangman.ui.hangman

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mijaz.hangman.GameModel

class GameViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val game = GameModel()

    private var _word = MutableLiveData<String>()
    var word: LiveData<String> = _word

    private var _solution = MutableLiveData<String>()
    var solution: LiveData<String> = _solution

    init {
        _word.value = game.currentWord.word
        _solution.value = game.solution
    }
}
