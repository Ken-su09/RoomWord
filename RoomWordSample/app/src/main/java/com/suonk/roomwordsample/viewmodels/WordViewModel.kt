package com.suonk.roomwordsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.suonk.roomwordsample.models.data.Word
import com.suonk.roomwordsample.repositories.WordDataRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordDataRepository) : ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insertWord(word)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun delete(word: Word) = viewModelScope.launch {
        repository.delete(word)
    }
}