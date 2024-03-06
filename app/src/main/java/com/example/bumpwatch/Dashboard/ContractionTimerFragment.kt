package com.example.bumpwatch.Dashboard

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R
import java.text.SimpleDateFormat
import java.util.Locale

class ContractionTimerFragment : Fragment() {

    private lateinit var textViewTimer: TextView
    private lateinit var buttonStartStop: Button
    private lateinit var buttonReset: Button
    private lateinit var listViewContractions: ListView
    private lateinit var contractionListAdapter: ArrayAdapter<String>
    private var isTimerRunning = false
    private lateinit var timer: CountDownTimer
    private val contractionTimes = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contraction_timer, container, false)

        textViewTimer = view.findViewById(R.id.textViewTimer)
        buttonStartStop = view.findViewById(R.id.buttonStartStop)
        buttonReset = view.findViewById(R.id.buttonReset)
        listViewContractions = view.findViewById(R.id.listViewContractions)

        contractionListAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, contractionTimes)
        listViewContractions.adapter = contractionListAdapter

        buttonStartStop.setOnClickListener {
            if (isTimerRunning) {
                stopTimer()
            } else {
                startTimer()
            }
        }

        buttonReset.setOnClickListener {
            resetTimer()
        }

        return view
    }

    private fun startTimer() {
        timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
            var elapsedTime = 0L
            override fun onTick(millisUntilFinished: Long) {
                elapsedTime += 1000
                updateTimerDisplay(elapsedTime)
            }

            override fun onFinish() {
                // Timer finished
            }
        }
        timer.start()
        isTimerRunning = true
        buttonStartStop.text = "Stop"
        addContractionTime(getCurrentTime())
    }

    private fun stopTimer() {
        timer.cancel()
        isTimerRunning = false
        buttonStartStop.text = "Start"
        addContractionTime(getCurrentTime())
    }

    private fun resetTimer() {
        timer.cancel()
        isTimerRunning = false
        textViewTimer.text = "00:00:00"
        contractionTimes.clear() // Clear the list of contractions
        contractionListAdapter.notifyDataSetChanged() // Notify the adapter of the change
        buttonStartStop.text = "Start"
    }

    private fun updateTimerDisplay(elapsedTime: Long) {
        val hours = (elapsedTime / 3600000).toInt()
        val minutes = ((elapsedTime % 3600000) / 60000).toInt()
        val seconds = ((elapsedTime % 60000) / 1000).toInt()
        val timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds)
        textViewTimer.text = timeString
    }

    private fun addContractionTime(time: String) {
        contractionTimes.add(time)
        contractionListAdapter.notifyDataSetChanged() // Notify the adapter of the change
    }



    private fun getCurrentTime(): String {
        val currentTime = System.currentTimeMillis()
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return sdf.format(currentTime)
    }

}

