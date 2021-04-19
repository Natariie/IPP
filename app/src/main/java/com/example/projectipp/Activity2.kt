package com.example.projectipp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectipp.databinding.Activity2Binding

open class Activity2 : AppCompatActivity() {

    companion object{
        var isNewVal1 : Boolean = false
        var isNewVal2 : Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding : Activity2Binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val popupMenu1 = PopupMenu(
            this,
            binding.setTimerValue1
        )
        val popupMenu2 = PopupMenu(
            this,
            binding.setTimerValue2
        )

        popupMenu1.menuInflater.inflate(R.menu.timer_menu1, popupMenu1.menu)
        popupMenu2.menuInflater.inflate(R.menu.timer_menu2, popupMenu2.menu)

        popupMenu1.setOnMenuItemClickListener { menuItem ->

            val id = menuItem.itemId

            val prefVal1 = "1"
            val prefVal2 = "2"
            val prefVal3 = "3"
            val prefVal4 = "4"

            val sharedPreferences1: SharedPreferences = getSharedPreferences(
                "sharedPrefs",
                MODE_PRIVATE
            )
            val editor = sharedPreferences1.edit()

            when(id){
                R.id.one -> {
                    binding.setTimerValue1.text = prefVal1
                    editor.apply {
                        putString("VAL1_KEY", prefVal1)
                    }.apply()
                    isNewVal1 = true
                }
                R.id.two -> {
                    binding.setTimerValue1.text = prefVal2
                    editor.apply {
                        putString("VAL1_KEY", prefVal2)
                    }.apply()
                    isNewVal1 = true
                }
                R.id.three -> {
                    binding.setTimerValue1.text = prefVal3
                    editor.apply {
                        putString("VAL1_KEY", prefVal3)
                    }.apply()
                    isNewVal1 = true
                }
                R.id.four -> {
                    binding.setTimerValue1.text = prefVal4
                    editor.apply {
                        putString("VAL1_KEY", prefVal4)
                    }.apply()
                    isNewVal1 = true
                }
            }

            false
        }


        val sharedPreferences1: SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val savedVal1 = sharedPreferences1.getString("VAL1_KEY", "1")
        binding.setTimerValue1.text = savedVal1


        popupMenu2.setOnMenuItemClickListener { menuItem ->

            val id = menuItem.itemId

            val prefVal1 = "seconds"
            val prefVal2 = "minutes"
            val prefVal3 = "hours"
            val prefVal4 = "days"
            val prefVal5 = "weeks"

            val sharedPreferences: SharedPreferences = getSharedPreferences(
                "sharedPrefs",
                MODE_PRIVATE
            )
            val editor = sharedPreferences.edit()

            when(id){
                R.id.seconds -> {
                    binding.setTimerValue2.text = prefVal1
                    editor.apply {
                        putString("VAL2_KEY", prefVal1)
                    }.apply()
                    isNewVal2 = true
                }
                R.id.minutes -> {
                    binding.setTimerValue2.text = prefVal2
                    editor.apply {
                        putString("VAL2_KEY", prefVal2)
                    }.apply()
                    isNewVal2 = true
                }
                R.id.hours -> {
                    binding.setTimerValue2.text = prefVal3
                    editor.apply {
                        putString("VAL2_KEY", prefVal3)
                    }.apply()
                    isNewVal2 = true
                }
                R.id.days -> {
                    binding.setTimerValue2.text = prefVal4
                    editor.apply {
                        putString("VAL2_KEY", prefVal4)
                    }.apply()
                    isNewVal2 = true
                }
                R.id.weeks -> {
                    binding.setTimerValue2.text = prefVal5
                    editor.apply {
                        putString("VAL2_KEY", prefVal5)
                    }.apply()
                    isNewVal2 = true

                }
            }

            false
        }


        val sharedPreferences2: SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val savedVal2 = sharedPreferences2.getString("VAL2_KEY", "days")
        binding.setTimerValue2.text = savedVal2

        binding.saveButton.setOnClickListener(){

            val sharedPreferences3: SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
            val savedVal1 = sharedPreferences3.getString("VAL1_KEY", "1")
            binding.setTimerValue1.text = savedVal1

            val sharedPreferences4: SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
            val savedVal2 = sharedPreferences4.getString("VAL2_KEY", "days")
            binding.setTimerValue2.text = savedVal2

            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("VAL1_KEY", savedVal1)
            intent2.putExtra("VAL2_KEY", savedVal2)

            Toast.makeText(this, "Will send a reminder in: " + savedVal1 + " " + savedVal2, Toast.LENGTH_SHORT).show()

            startActivity(intent2)
        }

        binding.setTimerValue1.setOnClickListener(){
            popupMenu1.show()
        }

        binding.setTimerValue2.setOnClickListener(){
            popupMenu2.show()
        }

        isNewVal1 = false
        isNewVal2 = false

    }

}