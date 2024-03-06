package com.example.bumpwatch.Dashboard


/**
 * A simple [Fragment] subclass.
 * Use the [AppointmentTrackerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import com.example.bumpwatch.R
import java.net.URLEncoder

class AppointmentTrackerFragment : Fragment() {

    private lateinit var appointmentDatePicker: DatePicker
    private lateinit var appointmentTimePicker: TimePicker
    private lateinit var doctorNameEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_appointment_tracker, container, false)

        appointmentDatePicker = view.findViewById(R.id.appointmentDatePicker)
        appointmentTimePicker = view.findViewById(R.id.appointmentTimePicker)
        doctorNameEditText = view.findViewById(R.id.doctorNameEditText)
        val saveAppointmentButton: Button = view.findViewById(R.id.saveAppointmentButton)
        saveAppointmentButton.setOnClickListener {
           // saveAppointment()
            whatsAppsaveAppointment()
        }

        return view
    }



    private fun whatsAppsaveAppointment() {
        // Get selected date
        val day = appointmentDatePicker.dayOfMonth
        val month = appointmentDatePicker.month + 1 // Month starts from 0, so add 1
        val year = appointmentDatePicker.year

        // Get selected time
        val hour = appointmentTimePicker.hour
        val minute = appointmentTimePicker.minute

        // Get doctor's name
        val doctorName = doctorNameEditText.text.toString()

        // Construct message
        val message = "Appointment Details\nDate: $day/$month/$year\nTime: $hour:$minute\nDoctor's Name: $doctorName"

        // Open WhatsApp with specific contact
        val contactNumber = "+254729544650" // Replace this with the actual phone number of the contact on WhatsApp used dyllans number
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=$contactNumber&text=${URLEncoder.encode(message, "UTF-8")}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }




}