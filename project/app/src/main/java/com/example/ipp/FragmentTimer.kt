package com.example.ipp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.ipp.databinding.FragmentTimerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentTimer.newInstance] factory method to
 * create an instance of this fragment.
 */

class FragmentTimer : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //to enable viewbinding in this fragment
    private var fragmentTimerBinding: FragmentTimerBinding? = null


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        //to enable viewbinding in this fragment
        val binding = FragmentTimerBinding.bind(view)
        fragmentTimerBinding = binding

        //to set the popupmenu to this fragments buttons(i.e. setTimerValue1 and setTimerValue2)
        val popupMenu1 = PopupMenu(
            context,
            binding.setTimerValue1
        )
        val popupMenu2 = PopupMenu(
            context,
            binding.setTimerValue2
        )

        //inflate the menu items and associate them with previously defined popupmenus
        popupMenu1.menuInflater.inflate(R.menu.timer_menu1, popupMenu1.menu)
        popupMenu2.menuInflater.inflate(R.menu.timer_menu2, popupMenu2.menu)

        //first preference to be saved (first button on the left)
        val sharedPref1: SharedPreferences? = activity?.getSharedPreferences("sharedPrefs", MODE_PRIVATE)

        //editor allows us to use .apply, which commits the changes
        val editor = sharedPref1?.edit()

        //value for the latest option selected to be saved. If no preferences exist return default value
        val savedVal1 = sharedPref1?.getString("MENU1_KEY", "1")

        //use binding to access this fragments layout and change the corresponding text accordingly
        binding.setTimerValue1.text = savedVal1

        popupMenu1.setOnMenuItemClickListener { menuItem ->

            val id = menuItem.itemId

            //preferred values that can be chosen from the first menus
            val prefVal1 = "1"
            val prefVal2 = "2"
            val prefVal3 = "3"
            val prefVal4 = "4"


            //depending on the id-name, apply and commit the changes.
            when(id){
                R.id.one -> {
                    binding.setTimerValue1.text = prefVal1
                    editor?.apply {
                        putString("MENU1_KEY", prefVal1)
                    }?.apply()
                }
                R.id.two -> {
                    binding.setTimerValue1.text = prefVal2
                    editor?.apply {
                        putString("MENU1_KEY", prefVal2)
                    }?.apply()
                }
                R.id.three -> {
                    binding.setTimerValue1.text = prefVal3
                    editor?.apply {
                        putString("MENU1_KEY", prefVal3)
                    }?.apply()
                }
                R.id.four -> {
                    binding.setTimerValue1.text = prefVal4
                    editor?.apply {
                        putString("MENU1_KEY", prefVal4)
                    }?.apply()
                }
            }

            false
        }


        //second preference to be saved (first button on the right)
        val sharedPref2: SharedPreferences? = activity?.getSharedPreferences("sharedPrefs", MODE_PRIVATE)

        //value for the latest option selected to be saved. If no preferences exist return default value
        val savedVal2 = sharedPref2?.getString("MENU2_KEY", "days")

        //use binding to access this fragments layout and change the corresponding text accordingly
        binding.setTimerValue2.text = savedVal2


        popupMenu2.setOnMenuItemClickListener { menuItem ->

            val id = menuItem.itemId

            //preferred values that can be chosen from the second menus
            val prefVal1 = "seconds"
            val prefVal2 = "minutes"
            val prefVal3 = "hours"
            val prefVal4 = "days"
            val prefVal5 = "weeks"

            //depending on the id-name, apply and commit the changes.
            when(id){
                R.id.seconds -> {
                    binding.setTimerValue2.text = prefVal1
                    editor?.apply {
                        putString("MENU2_KEY", prefVal1)
                    }?.apply()
                }
                R.id.minutes -> {
                    binding.setTimerValue2.text = prefVal2
                    editor?.apply {
                        putString("MENU2_KEY", prefVal2)
                    }?.apply()
                }
                R.id.hours -> {
                    binding.setTimerValue2.text = prefVal3
                    editor?.apply {
                        putString("MENU2_KEY", prefVal3)
                    }?.apply()
                }
                R.id.days -> {
                    binding.setTimerValue2.text = prefVal4
                    editor?.apply {
                        putString("MENU2_KEY", prefVal4)
                    }?.apply()
                }
                R.id.weeks -> {
                    binding.setTimerValue2.text = prefVal5
                    editor?.apply {
                        putString("MENU2_KEY", prefVal5)
                    }?.apply()
                }
            }

            false
        }


        //once appropriate options have been selected, press save
        binding.saveButton.setOnClickListener(){

            //update the preferences to make sure they're equal to the changes made in the case statement scopes
            val sharedPreferences3: SharedPreferences? = activity?.getSharedPreferences("sharedPrefs", MODE_PRIVATE)                   //när man klickar på save så sparas båda inställningarna
            val savedVal1 = sharedPreferences3?.getString("MENU1_KEY", "1")
            binding.setTimerValue1.text = savedVal1

            val sharedPreferences4: SharedPreferences? = activity?.getSharedPreferences("sharedPrefs", MODE_PRIVATE)
            val savedVal2 = sharedPreferences4?.getString("MENU2_KEY", "days")
            binding.setTimerValue2.text = savedVal2

            //friendly reminder
            Toast.makeText(context, "Will send a reminder in: " + savedVal1 + " " + savedVal2, Toast.LENGTH_SHORT).show()

            //pass the saved values as argument to startTimer method of MainActivity class
            (activity as MainActivity).startTimer(savedVal1, savedVal2)

        }

        //this is needed for the menus to actually show up when they're clicked
        binding.setTimerValue1.setOnClickListener(){
            popupMenu1.show()
        }

        binding.setTimerValue2.setOnClickListener(){
            popupMenu2.show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Returns inflated layout as a constant. This is to make it possible to use findViewById
        val inflateLayout = inflater.inflate(R.layout.fragment_timer, container, false)

        val buttonStatus = inflateLayout.findViewById<Button>(R.id.button_back)
        buttonStatus.setOnClickListener {
            (activity as MainActivity).click(R.id.fragment, FragmentChoiceMenu())
        }

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflateLayout
    }

}