package com.example.todolistapp.onboarding.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.todolistapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AppBar : Fragment() {
    private lateinit var navview: BottomNavigationView
    private lateinit var plusButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.appbar, container, false)

        navview = view.findViewById(R.id.nav_view)
        plusButton = view.findViewById(R.id.plus_button)

        replaceFragment(ListTask())

        navview.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_notes -> replaceFragment(ListTask())
                R.id.nav_done -> replaceFragment(CompleteTask())
            }
            true
        }


        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.appbar, fragment)
        fragmentTransaction.commit()
    }

}
