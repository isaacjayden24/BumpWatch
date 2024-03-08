package com.example.bumpwatch.Model

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bumpwatch.R
import com.google.android.material.textfield.TextInputLayout


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)
       /* val button = view.findViewById<Button>(R.id.next_button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            //onSubmit()
        }*/

        // Set an error if the password is less than 8 characters.
        val passwordEditText=view!!.findViewById<EditText>(R.id.password_edit_text)
        val passwordTextInput=view.findViewById<TextInputLayout>(R.id.password_text_input)
        val nextButton=view.findViewById<Button>(R.id.next_button)
        val signupBtn=view.findViewById<Button>(R.id.signup_button)

        signupBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        nextButton.setOnClickListener {
            if (!isPasswordValid(passwordEditText.text!!)) {
                passwordTextInput.error = getString(R.string.shr_error_password)
            } else {
                // Clear the error.
                passwordTextInput.error = null
                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            }
        }
        val passwordEdit=view.findViewById<EditText>(R.id.password_edit_text)
        // Clear the error once more than 8 characters are typed.
        passwordEdit.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(passwordEdit.text!!)) {
                // Clear the error.
                passwordTextInput.error = null

            }
            false
        }



        return view



    }

    private fun isPasswordValid(text: Editable):Boolean{
        return text != null && text.length >= 8
    }


}