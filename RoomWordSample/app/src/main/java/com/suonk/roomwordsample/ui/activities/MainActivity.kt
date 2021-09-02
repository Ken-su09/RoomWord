package com.suonk.roomwordsample.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.suonk.roomwordsample.R
import com.suonk.roomwordsample.databinding.ActivityMainBinding
import com.suonk.roomwordsample.models.App
import com.suonk.roomwordsample.models.data.Word
import com.suonk.roomwordsample.ui.adapters.WordListAdapter
import com.suonk.roomwordsample.viewmodels.WordViewModel
import com.suonk.roomwordsample.viewmodels.WordViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = binding.recyclerview
        fab = binding.fab
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel.allWords.observe(this) { words ->
            words.let { adapter.submitList(it) }
        }

        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, NewWordActivity::class.java))
        }
    }
}