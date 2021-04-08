package com.example.projectipp

import android.content.Context
import android.content.SharedPreferences

class Preferences(context : Context){

    private val prefVal1 = "one"
    val prefVal2 = "two"
    val prefVal3 = "three"
    val prefVal4 = "four"

    val preference: SharedPreferences = context.getSharedPreferences(prefVal1, Context.MODE_PRIVATE)

    fun getTimerValues1() : Int{
        return preference.getInt(prefVal1, 5)
    }

    fun setTimerValues1(value: Int){
        val editor = preference.edit()
        editor.putInt(prefVal1, value)
        editor.apply()
    }


}