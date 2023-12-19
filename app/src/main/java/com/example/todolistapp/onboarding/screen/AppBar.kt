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
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class AppBar : Fragment(R.layout.activity_main) {
    private lateinit var navview: BottomNavigationView
    private lateinit var plusButton: FloatingActionButton
    private lateinit var bottomSheet: View



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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheet = view.findViewById(R.id.plus_button)
        bottomSheet.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        context?.let { ctx ->
            val dialog = Dialog(ctx)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.bottomsheetlayout)

            val editLayout: LinearLayout = dialog.findViewById(R.id.layoutEdit)
            val shareLayout: LinearLayout = dialog.findViewById(R.id.layoutShare)
            val uploadLayout: LinearLayout = dialog.findViewById(R.id.layoutUpload)
            val printLayout: LinearLayout = dialog.findViewById(R.id.layoutPrint)

            editLayout.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(ctx, "Edit is Clicked", Toast.LENGTH_SHORT).show()
            }

            shareLayout.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(ctx, "Share is Clicked", Toast.LENGTH_SHORT).show()
            }

            uploadLayout.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(ctx, "Upload is Clicked", Toast.LENGTH_SHORT).show()
            }

            printLayout.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(ctx, "Print is Clicked", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
            dialog.window?.setGravity(Gravity.BOTTOM)
        }
    }



}
