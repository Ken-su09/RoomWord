package com.suonk.roomwordsample.repositories

import androidx.annotation.WorkerThread
import com.suonk.roomwordsample.models.data.Word
import com.suonk.roomwordsample.models.data.WordDAO
import kotlinx.coroutines.flow.Flow

class WordDataRepository(private val wordDAO: WordDAO) {

    val allWords: Flow<List<Word>> = wordDAO.getWordsOrderByAlphabet()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertWord(word: Word) {
        wordDAO.insert(word)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll() {
        wordDAO.deleteAll()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(word: Word) {
        wordDAO.delete(word)
    }
}