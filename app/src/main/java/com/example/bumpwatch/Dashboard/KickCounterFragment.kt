package com.example.bumpwatch.Dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView




class KickCounterFragment : Fragment() {

    private lateinit var textViewCounter: MaterialTextView
    private lateinit var buttonIncrement: MaterialButton
    private lateinit var buttonReset: MaterialButton
    private var kickCount: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kick_counter, container, false)

        textViewCounter = view.findViewById(R.id.textViewCounter)
        buttonIncrement = view.findViewById(R.id.buttonIncrement)
        buttonReset = view.findViewById(R.id.buttonReset)

        textViewCounter.text = kickCount.toString()

        buttonIncrement.setOnClickListener {
            incrementKickCount()
        }

        buttonReset.setOnClickListener {
            resetKickCount()
        }

        return view
    }

    private fun incrementKickCount() {
        kickCount++
        textViewCounter.text = kickCount.toString()

    }

    private fun resetKickCount() {
        kickCount = 0
        textViewCounter.text = kickCount.toString()
    }

}









