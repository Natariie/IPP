package com.example.projectipp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectipp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.TimerButton.setOnClickListener(){
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

    }
}