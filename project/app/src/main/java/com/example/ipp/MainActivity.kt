package com.example.ipp

import android.Manifest
import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

private const val PERMISSION_CODE = 1
private const val REQUEST_ENABLE_BT = 2

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    private lateinit var buttonStart : Button
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bluetooth()

        // - - - Click events - - -
        buttonStart = findViewById(R.id.button_start)
        buttonStart.setOnClickListener {
            click(R.id.fragment, FragmentChoiceMenu())
        }

    }


    fun startTimer(key1 : String?, key2 : String?){
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

    private fun bluetooth () {
        // Used developer.android documentation as source from https://developer.android.com/guide/topics/connectivity/bluetooth#TheBasics
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(baseContext, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), PERMISSION_CODE)
            }
        }
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Log.d("tagged", "Doesn't support bluetooth")
        }
        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        }
    }

    fun click(currentFragmentId: Int, changeIntoFragment: Fragment, backStack: String? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(currentFragmentId, changeIntoFragment)
        // The addToBacStack should make the user able to go back to the last fragment by pressing the back button.
        transaction.addToBackStack(backStack).commit()
    }

    fun timer() {

    }

    fun showDevices() {
        val devices = bluetoothAdapter?.bondedDevices
        val listView = findViewById<ListView>(R.id.device_list)
        val deviceList : ArrayList<String> = arrayListOf()
        if (devices != null) {
            for(device in devices) {
                val deviceName = device.name
                deviceList += deviceName
            }
            Log.d("Tagged", deviceList.toString())
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, deviceList)
            listView.adapter = arrayAdapter
        }
    }
}