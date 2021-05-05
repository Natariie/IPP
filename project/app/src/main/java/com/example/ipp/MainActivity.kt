package com.example.ipp

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

private const val SELECT_DEVICE_REQUEST_CODE = 0
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
            click(R.id.fragment_start_menu, FragmentChoiceMenu())
        }
    }

    // Found bug where it does not properly go back to previous fragment (maybe fragment transaction is not properly replaced?)
    // This function isn't a solution but will prevent user from pressing back button on phone and instead needs to press back button
    override fun onBackPressed() {}

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
        // The addToBacStack should make the user able to go back to the last fragment by pressing the back button. (not working properly atm)
        transaction.addToBackStack(backStack).commit()
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