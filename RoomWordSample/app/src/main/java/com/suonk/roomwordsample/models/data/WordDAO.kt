package com.suonk.roomwordsample.models.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDAO {

    /**
     * getWordsOrderByAlphabet() = word1, word2, word3
     */
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getWordsOrderByAlphabet(): Flow<List<Word>>

    /**
     * insert(word)
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    /**
     * delete(word)
     */
    @Delete
    suspend fun delete(word: Word)

    /**
     * deleteAll()
     */
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}