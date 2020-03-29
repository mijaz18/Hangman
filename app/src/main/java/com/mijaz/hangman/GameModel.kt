package com.mijaz.hangman

import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class GameModel{


    data class WordSol(val word: String, val solution: String)

    private val wordSol: List<WordSol> = listOf(
        WordSol(
            word = "abr_p_ly",
            solution = "abruptly"
        ),
        WordSol(
            word = "ab_u_d",
            solution = "absurd"
        ),
        WordSol(
            word = "ab_s_",
            solution = "abyss"
        ),
        WordSol(
            word = "af_i_",
            solution = "affix"
        )
       // "abruptly","absurd","abyss","affix","askew","avenue","awkward","axiom"
    )

    lateinit var currentWord: WordSol
    lateinit var solution: String

    init {
        newWord()
    }

    fun newWord(){
        currentWord = wordSol[Random.nextInt(wordSol.size)]
        solution = currentWord.solution
    }

}