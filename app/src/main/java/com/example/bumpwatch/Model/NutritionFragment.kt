package com.example.bumpwatch.Model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bumpwatch.R



/**
 * A simple [Fragment] subclass.
 * Use the [NutritionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NutritionFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_nutrition, container, false)
        //navigate to the workout fragment
        val pregnancyCard=view.findViewById<CardView>(R.id.pregnancy_week)
        val pregnancyText=view.findViewById<TextView>(R.id.pregnancy_weektext)
        //navigate to the Meal planner fragment
        val mealCard=view.findViewById<CardView>(R.id.meal_cardview)
        val mealText=view.findViewById<TextView>(R.id.meal_textview)
        //navigate to the exercise fragment
        val exerciseCard=view.findViewById<CardView>(R.id.exercise_cardview)
        val exerciseText=view.findViewById<TextView>(R.id.exercise_textview)
        //navigate to the community fragment
        val communityCard=view.findViewById<CardView>(R.id.community_card)
        val communityText=view.findViewById<TextView>(R.id.community_text)

        pregnancyCard.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_workoutTutorialFragment)
        }
        pregnancyText.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_workoutTutorialFragment)
        }


        mealCard.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_mealPlannerFragment)
        }
        mealText.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_mealPlannerFragment)
        }

        exerciseCard.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_exerciseTrackerFragment)
        }
        exerciseText.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_exerciseTrackerFragment)
        }

        communityCard.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_communitysupportFragment)
        }
        communityText.setOnClickListener(){
            findNavController().navigate(R.id.action_nutritionFragment_to_communitysupportFragment)
        }


        return view
    }


}