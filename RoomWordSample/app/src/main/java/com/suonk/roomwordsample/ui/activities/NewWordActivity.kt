package com.suonk.roomwordsample.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.suonk.roomwordsample.databinding.ActivityNewWordBinding
import com.suonk.roomwordsample.models.App
import com.suonk.roomwordsample.models.data.Word
import com.suonk.roomwordsample.viewmodels.WordViewModel
import com.suonk.roomwordsample.viewmodels.WordViewModelFactory

class NewWordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewWordBinding
    private lateinit var editText: AppCompatEditText
    private lateinit var button: AppCompatButton

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUI()
    }

    private fun initializeUI() {
        editText = binding.editWord
        button = binding.buttonSave

        button.setOnClickListener {
            buttonSaveClick()
        }
    }

    private fun buttonSaveClick() {
        val word = Word(editText.text.toString())
        wordViewModel.insert(word)
        finish()
    }
}