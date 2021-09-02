package com.suonk.roomwordsample.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    @ColumnInfo(name = "word")
    val word: String,
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)