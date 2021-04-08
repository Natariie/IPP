package com.example.projectipp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.example.projectipp.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding : Activity2Binding = Activity2Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

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

        val preferences = Preferences(this)
        var timerPref1 =  preferences.getTimerValues1()

        popupMenu1.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId

            when(id){
                R.id.one -> binding.setTimerValue1.text = "1"
                R.id.two -> binding.setTimerValue1.text = timerPref1.toString()
                R.id.three -> binding.setTimerValue1.text = "3"
                R.id.four -> binding.setTimerValue1.text = "4"
            }


            false
        }

        preferences.setTimerValues1(timerPref1)
        binding.setTimerValue1.text = timerPref1.toString()

        popupMenu2.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId

            when(id){
                R.id.minutes -> binding.setTimerValue2.text = R.string.minutes.toString()
                R.id.two -> binding.setTimerValue2.text = R.string.hours.toString()
                R.id.three -> binding.setTimerValue2.text = R.string.days.toString()
                R.id.four -> binding.setTimerValue2.text = R.string.weeks.toString()
            }


            false
        }

        binding.setTimerValue1.setOnClickListener(){
            popupMenu1.show()
        }

        binding.setTimerValue2.setOnClickListener(){
            popupMenu2.show()
        }

    }

}