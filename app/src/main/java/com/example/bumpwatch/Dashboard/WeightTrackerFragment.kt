package com.example.bumpwatch.Dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R

class WeightEntry(val year: Int, val month: Int, val day: Int, val weight: Double) {
    override fun toString(): String {
        return "Date: ${String.format("%02d", month + 1)}/${String.format("%02d", day)}/$year - Weight: $weight lbs"
    }
}

class WeightTrackerFragment : Fragment() {

    private lateinit var weightEntryEditText: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var saveWeightButton: Button
    private lateinit var retrieveWeightsButton: Button
    private lateinit var weightListView: ListView

    private val weightEntries = mutableListOf<WeightEntry>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weight_tracker, container, false)

        weightEntryEditText = view.findViewById(R.id.weightEntryEditText)
        datePicker = view.findViewById(R.id.datePicker)
        saveWeightButton = view.findViewById(R.id.saveWeightButton)
        retrieveWeightsButton = view.findViewById(R.id.retrieveWeightsButton)
        weightListView = view.findViewById(R.id.weightListView)

        saveWeightButton.setOnClickListener {
            saveWeightEntry()
        }

        retrieveWeightsButton.setOnClickListener {
            displayWeightEntries()
        }

        return view
    }

    private fun saveWeightEntry() {
        val weightString = weightEntryEditText.text.toString()
        if (weightString.isEmpty()) {
            // Display error message indicating weight is required
            Toast.makeText(context, "Please enter your weight", Toast.LENGTH_SHORT).show()
            return
        }

        val weight = weightString.toDouble()
        // Get the selected date from the DatePicker
        val year = datePicker.year
        val month = datePicker.month
        val day = datePicker.dayOfMonth

        // Create a new WeightEntry object and add it to the list
        weightEntries.add(WeightEntry(year, month, day, weight))

        // Display a success message
        Toast.makeText(context, "Weight entry saved", Toast.LENGTH_SHORT).show()

        // Clear the input fields
        weightEntryEditText.text.clear()
    }

    private fun displayWeightEntries() {
        // Create an ArrayList of strings to display weight entries in ListView
        val displayEntries = ArrayList<String>()
        for (entry in weightEntries) {
            displayEntries.add(entry.toString())
        }

        // Create an ArrayAdapter to bind the ArrayList to the ListView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, displayEntries)
        weightListView.adapter = adapter
    }
}



