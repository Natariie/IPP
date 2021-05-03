package com.example.ipp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentChoiceMenu.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentChoiceMenu : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Returns inflated layout as a constant. This is to make it possible to use findViewById
        val inflateLayout = inflater.inflate(R.layout.fragment_choice_menu, container, false)
        // All the buttons for Choice Menu
        val buttonConnectToBluetooth = inflateLayout.findViewById<Button>(R.id.button_connect_to_bluetooth)
        val buttonStatus = inflateLayout.findViewById<Button>(R.id.button_check_status)
        val buttonTimer = inflateLayout.findViewById<Button>(R.id.button_check_timer)
        val buttonHelp = inflateLayout.findViewById<Button>(R.id.button_help)

        buttonConnectToBluetooth.setOnClickListener() {
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.id_fragment_choice_menu, fragmentBluetooth())
            transaction.addToBackStack(null).commit()

            Log.d("tagged", "clickBluetooth")
        }

        buttonStatus.setOnClickListener() {
            Log.d("tagged", "clickStatus")
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
         * @return A new instance of fragment FragmentChoiceMenu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentChoiceMenu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}