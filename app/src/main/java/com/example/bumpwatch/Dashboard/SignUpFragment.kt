package com.example.bumpwatch.Dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bumpwatch.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_sign_up, container, false)
        val cancelBtn=view.findViewById<Button>(R.id.cancel_button)
         val signUpBtn=view.findViewById<Button>(R.id.sign_up_button)
        signUpBtn.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_dashboardFragment)
        }
        cancelBtn.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        return view
    }


}