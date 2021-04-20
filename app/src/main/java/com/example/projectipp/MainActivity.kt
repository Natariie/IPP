package com.example.projectipp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.projectipp.databinding.Activity2Binding
import com.example.projectipp.databinding.ActivityMainBinding


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        val binding2 : Activity2Binding = Activity2Binding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        binding.TimerButton.setOnClickListener(){

            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)

        }

        val key1 = intent.getStringExtra("VAL1_KEY")
        val key2 = intent.getStringExtra("VAL2_KEY")

        if(key1 != null && key2 != null){
            startTimer(key1, key2)
        }
        else if(key1 == null && key2 == null){
            startTimer(
                binding2.setTimerValue1.text as String?,
                binding2.setTimerValue2.text as String?
            )
        }

    }

    open fun startTimer(key1: String?, key2: String?){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Refill")
        builder.setMessage("This is a reminder that you need to refill your glucose and insulin.")

        when(key1){
            "1" -> {
                if (key2 == "seconds") {
                    val timer = object : CountDownTimer(1000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {}

                        override fun onFinish() {
                            builder.setPositiveButton("Got it!") { _, _ ->

                            }
                            builder.show()
                        }
                    }
                    timer.start()
                }
            }
            "2" -> {
                if (key2 == "seconds") {
                    val timer = object : CountDownTimer(2000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {}

                        override fun onFinish() {
                            builder.setPositiveButton("Got it!") { _, _ ->

                            }
                            builder.show()
                        }
                    }
                    timer.start()
                }
            }
            "3" -> {
                if (key2 == "seconds") {
                    val timer = object : CountDownTimer(3000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {}

                        override fun onFinish() {
                            builder.setPositiveButton("Got it!") { _, _ ->

                            }
                            builder.show()
                        }
                    }
                    timer.start()
                }
            }
            "4" -> {
                if (key2 == "seconds") {
                    val timer = object : CountDownTimer(4000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {}

                        override fun onFinish() {
                            builder.setPositiveButton("Got it!") { _, _ ->

                            }
                            builder.show()
                        }
                    }
                    timer.start()
                }
            }
        }

    }
}