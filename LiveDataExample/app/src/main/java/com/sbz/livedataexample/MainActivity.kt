package com.sbz.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    private val tvTextView: TextView
        get() = findViewById(R.id.tv_exampleView)

    val btnUpdate: Button
        get() = findViewById(R.id.btnPerformAction)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val someValue = mainViewModel.liveData.observe(this) {
            tvTextView.text = it
            Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this@MainActivity, "$someValue", Toast.LENGTH_SHORT).show()


        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }

    }
}