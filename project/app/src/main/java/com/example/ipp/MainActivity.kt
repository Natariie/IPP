package com.example.ipp

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private val PERMISSION_CODE = 1
    private val REQUEST_ENABLE_BT = 2
    private lateinit var buttonStart : Button
    private lateinit var buttonBluetooth : Button

    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

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

        // Used developer.android documentation as source from https://developer.android.com/guide/topics/connectivity/bluetooth#TheBasics
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(baseContext,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    // PERMISSION_CODE is 1
                    arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                    PERMISSION_CODE)
            }
        }

        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Log.d("tagged", "Doesn't support bluetooth")
        }
        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            // REQUEST_ENABLE_BT is 1
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        }

        // Register for broadcasts when a device is discovered.
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        registerReceiver(receiver, filter)

        bluetoothAdapter?.startDiscovery()
    }

    fun discovery () {
        bluetoothAdapter?.startDiscovery()
        Log.d("tagged", "started discovery")
    }

    fun showDevices() {
        val devices = bluetoothAdapter?.bondedDevices
        val listview = findViewById<ListView>(R.id.device_list)
        val deviceList : ArrayList<String> = arrayListOf()
        if (devices != null) {
            for(device in devices) {
                val deviceName = device.name
                deviceList += deviceName

            }
            Log.d("Tagged", deviceList.toString())
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, deviceList)
            listview.adapter = arrayAdapter
        }
    }

    // Create a BroadcastReceiver for ACTION_FOUND.
    val receiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            when(intent.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    // Discovery has found a device. Get the BluetoothDevice
                    // object and its info from the Intent.
                    val device: BluetoothDevice? =
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    val deviceName = device?.name



                    val deviceHardwareAddress = device?.address // MAC address
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(receiver)
    }


}



// Classic Bluetooh (not Low Energy Bluetooth)
// Bluetooth Android documentation on https://developer.android.com/guide/topics/connectivity/bluetooth

// Bluetooth YT video https://youtu.be/PtN6UTIu7yw

