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
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dashboard, container, false)
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        //navigate to the pregnancy week fragment
        val cardView = view.findViewById<CardView>(R.id.pregnancy_week)
        val textView = view.findViewById<TextView>(R.id.pregnancy_weektext)

        //navigate to the appointment tracker fragment
        val cardViewAppointment=view.findViewById<CardView>(R.id.appointment_cardview)
        val textViewAppointment=view.findViewById<TextView>(R.id.appointment_textview)

        //navigate to the weight tracker fragment
        val cardviewWeight=view.findViewById<CardView>(R.id.weight_cardview)
        val textviewWeight=view.findViewById<TextView>(R.id.weight_textview)

        //navigate to the symptom tracker fragment
        val cardViewSymptom=view.findViewById<CardView>(R.id.symptom_card)
        val textViewSymptom=view.findViewById<TextView>(R.id.symptom_text)

        // navigate to kick counter fragment
        val cardViewKick=view.findViewById<CardView>(R.id.kickcounter_cardview)
        val textviewKick=view.findViewById<TextView>(R.id.kickcounter_textview)

        // navigate to contraction timer fragment
        val cardviewContraction=view.findViewById<CardView>(R.id.contractiontimer_cardview)
        val textViewContraction=view.findViewById<TextView>(R.id.contractiontimer_textview)
        //navigate to nutrition and fitness
        val cardviewNutrition=view.findViewById<CardView>(R.id.nutritionfitness_cardview)
        val textviewNutrition=view.findViewById<TextView>(R.id.nutritionfitness_textview)

        //nutrition fitness fragment navigation
        cardviewNutrition.setOnClickListener{
            findNavController().navigate(R.id.action_dashboardFragment_to_nutritionFragment)
        }
        textviewNutrition.setOnClickListener{
            findNavController().navigate(R.id.action_dashboardFragment_to_nutritionFragment)
        }

        ///////////
        //pregnancy week clicklistener
        cardView.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_pregnancyWeekFragment)
        }
//action_dashboardFragment_to_pregnancyWeekFragment

        textView.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_pregnancyWeekFragment)
        }

        /////////////
        //appointment tracker clicklistener
        cardViewAppointment.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_appointmentTrackerFragment)
        }


        textViewAppointment.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_appointmentTrackerFragment)
        }

        ////////////////////
        //weight tracker click listener
        cardviewWeight.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_weightTrackerFragment)
        }


        textviewWeight.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_weightTrackerFragment)
        }


        //////////////
        //symptom tracker clicklistner
       cardViewSymptom.setOnClickListener {
//action_dashboardFragment_to_pregnancyWeekFragment
           //action_dashboardFragment_to_symptomTrackerFragment
            findNavController().navigate(R.id.action_dashboardFragment_to_symptomsFragment)
        }


        textViewSymptom.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_symptomsFragment)
        }


        //////////
        //kickcounter fragment
        cardViewKick.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_kickCounterFragment)
        }


        textviewKick.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_kickCounterFragment)
        }

        /////////
        //contraction timer fragment
        cardviewContraction.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_contractionTimerFragment)
        }


        textViewContraction.setOnClickListener {

            findNavController().navigate(R.id.action_dashboardFragment_to_contractionTimerFragment)
        }





        return view
    }





    }
