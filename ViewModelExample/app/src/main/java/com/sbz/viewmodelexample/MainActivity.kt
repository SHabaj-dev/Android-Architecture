package com.sbz.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
        setContentView(R.layout.activity_main)
        tvCounter = findViewById(R.id.tv_showCount)
        showText()
    }

    private fun showText() {
        tvCounter.text = mainViewModel.count.toString()
    }


    fun increment(view: View) {
        mainViewModel.increment()
        showText()
    }
}