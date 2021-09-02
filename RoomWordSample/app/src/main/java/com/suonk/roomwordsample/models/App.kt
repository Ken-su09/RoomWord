package com.suonk.roomwordsample.models

import android.app.Application
import com.suonk.roomwordsample.repositories.WordDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordDataRepository(database.wordDao()) }
}