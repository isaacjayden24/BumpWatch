package com.example.bumpwatch.Nutrition


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R

class MealPlannerFragment : Fragment() {

    private lateinit var mondayMealTextView: TextView
    private lateinit var tuesdayMealTextView: TextView
    // Define variables for other days as needed
    private lateinit var addMealPlanButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)

        // Initialize views
        mondayMealTextView = view.findViewById(R.id.mondayMealTextView)
        tuesdayMealTextView = view.findViewById(R.id.tuesdayMealTextView)
        // Initialize views for other days as needed
        addMealPlanButton = view.findViewById(R.id.addMealPlanButton)

        // Set OnClickListener for the Add Meal Plan button
        addMealPlanButton.setOnClickListener {
            // Implement your logic to open a dialog or another activity to input meal plans
            // For demonstration purposes, let's assume the meal plans are already entered
            val mondayMealPlan = "Breakfast: Pancakes\nLunch: Caesar Salad\nDinner: Grilled Salmon"
            val tuesdayMealPlan = "Breakfast: Yogurt Parfait\nLunch: Turkey Wrap\nDinner: Vegetable Soup"

            // Update TextViews with the entered meal plans
            mondayMealTextView.text = mondayMealPlan
            tuesdayMealTextView.text = tuesdayMealPlan
            // Update TextViews for other days as needed
        }

        return view
    }
}