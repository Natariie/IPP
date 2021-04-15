package com.example.ipp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var buttonStart : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       buttonStart = findViewById(R.id.button_start)

        buttonStart.setOnClickListener(View.OnClickListener {
            Intent(this, ChoiceMenu::class.java).also {
                startActivity(it)
            }
        })
    }
}