package com.mijaz.hangman.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ConfigViewModel(application: Application) : AndroidViewModel(application) {

    val difficulty: List<String> = listOf(
        "Easy", "Medium", "Hard"
    )

    private val _diff = MutableLiveData<String>()
    var diff: LiveData<String> = _diff
}