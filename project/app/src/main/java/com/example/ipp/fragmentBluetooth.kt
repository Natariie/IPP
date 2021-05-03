package com.example.ipp

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentBluetooth.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentBluetooth : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        container?.removeAllViews()

        // Returns inflated layout as a constant. This is to make it possible to use findViewById
        val inflateLayout = inflater.inflate(R.layout.fragment_bluetooth, container, false)
        val REQUEST_CODE_DISCOVERABLE_BT = 3


        // To use functions in activity helping source was used https://www.tutorialspoint.com/how-to-call-an-activity-method-from-a-fragment-in-android-app-using-kotlin
        val buttonSearchForDevices = inflateLayout.findViewById<Button>(R.id.button_Search)
        buttonSearchForDevices.setOnClickListener {
            (activity as MainActivity?)!!.discovery()
        }

        val buttonShowDevices = inflateLayout.findViewById<Button>(R.id.button_show_devices)
        buttonShowDevices.setOnClickListener {
            (activity as MainActivity?)!!.showDevices()
        }

        // Inflate the layout for this fragment
        return inflateLayout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentBluetooth.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                fragmentBluetooth().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}