package com.example.ipp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var buttonStart : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Used YT video as helping source for switching fragment https://youtu.be/Nj4H4Xg4rjE
        buttonStart = findViewById(R.id.button_start)
        buttonStart.setOnClickListener {
            val start = FragmentChoiceMenu()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_start_menu, start)
            // The addToBacStack should make the user able to go back to the last fragment by pressing the back button.
            // However this is not needed for the main screen and therefore should be set to null
            // What's odd is that this doesn't seem to apply in the emulator.
            transaction.addToBackStack(null).commit()
        }
    }
}

// Classic Bluetooh (not Low Energy Bluetooth)
// Bluetooth Android documentation on https://developer.android.com/guide/topics/connectivity/bluetooth

// Bluetooth YT video https://youtu.be/PtN6UTIu7yw

