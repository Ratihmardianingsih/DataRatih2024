package com.example.todolistapp.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.todolistapp.R
import kotlinx.android.synthetic.main.bottomsheetlayout.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import java.util.*

class BottomSheet : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        val nama_task = view.findViewById<EditText>(R.id.nama_task)
        val deskripsi_task = view.findViewById<EditText>(R.id.deskripsi_task)




        val datePicker = view.findViewById<DatePicker>(R.id.datePicker)
        val submit = view.findViewById<Button>(R.id.submit)

        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        datePicker.init(year, month, day, null)



        submit.setOnClickListener {
            val name = nama_task.text.toString()
            val deskripsi = deskripsi_task.text.toString()

            val selectedYear = datePicker.year
            val selectedMonth = datePicker.month
            val selectedDay = datePicker.dayOfMonth


            dismiss()
    }
        return view
        }

}