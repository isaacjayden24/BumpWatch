package com.example.bumpwatch.Dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R

class SymptomsFragment : Fragment() {
    private lateinit var btn_save_symptom:Button
    private lateinit var edit_symptom_name:EditText
    private lateinit var edit_symptom_description:EditText
    private lateinit var text_display_symptom:TextView
    

    private val symptomList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_symptoms_tracking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_save_symptom = view.findViewById(R.id.btn_save_symptom)
        edit_symptom_name = view.findViewById(R.id.edit_symptom_name)
        edit_symptom_description = view.findViewById(R.id.edit_symptom_description)
        text_display_symptom = view.findViewById(R.id.text_display_symptom)


        // Save Symptom Button Click Listener
        btn_save_symptom.setOnClickListener {
            saveSymptom()
        }
    }

    private fun saveSymptom() {
        val symptomName = edit_symptom_name.text.toString()
        val symptomDescription = edit_symptom_description.text.toString()

        if (symptomName.isNotBlank()) {
            val symptom = "$symptomName: $symptomDescription"
            symptomList.add(symptom)
            edit_symptom_name.text.clear()
            edit_symptom_description.text.clear()
        }

        // Display all symptoms
        displaySymptoms()
    }

    private fun displaySymptoms() {
        val stringBuilder = StringBuilder()
        for (symptom in symptomList) {
            stringBuilder.append("$symptom\n")
        }
        text_display_symptom.text = stringBuilder.toString()
    }
}
