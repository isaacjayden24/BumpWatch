package com.example.bumpwatch.Nutrition





import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView

class ExerciseTrackerFragment : Fragment() {

    private lateinit var btn_save_exercise: Button
    private lateinit var date_picker: DatePicker
    private lateinit var edit_exercise: EditText
    private lateinit var text_display_exercise: TextView

    private val exerciseMap = mutableMapOf<String, String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exercise_tracker, container, false)

        // Initialize views
        btn_save_exercise = view.findViewById(R.id.btn_save_exercise)
        date_picker = view.findViewById(R.id.date_picker)
        edit_exercise = view.findViewById(R.id.edit_exercise)
        text_display_exercise = view.findViewById(R.id.text_display_exercise)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Save Exercise Button Click Listener
        btn_save_exercise.setOnClickListener {
            saveExercise()
        }
    }

    private fun saveExercise() {
        val selectedDate = getDateFromDatePicker()
        val exercise = edit_exercise.text.toString()

        if (exercise.isNotBlank()) {
            exerciseMap[selectedDate] = exercise
            edit_exercise.text.clear()
        }

        // Display all exercises
        displayExercises()
    }

    private fun getDateFromDatePicker(): String {
        val year = date_picker.year
        val month = date_picker.month
        val day = date_picker.dayOfMonth

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    private fun displayExercises() {
        val stringBuilder = StringBuilder()
        for ((date, exercise) in exerciseMap) {
            stringBuilder.append("$date: $exercise\n")
        }
        text_display_exercise.text = stringBuilder.toString()
    }
}

