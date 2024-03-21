package com.example.pizzadelivery.greeting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pizzadelivery.R

class AuthFragment : Fragment() {
    private lateinit var navController : NavController
    private lateinit var listener: OnAuthorizationSuccessListener
    private lateinit var connectWithEmailButton : Button
    private lateinit var connectWithPhoneNumber : Button
    private lateinit var connectWithGoogle : Button

    interface OnAuthorizationSuccessListener {
        fun onAuthorizationSuccess()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAuthorizationSuccessListener) {
            listener = context as OnAuthorizationSuccessListener
        } else {
            throw ClassCastException("$context должен быть OnAuthorizationSuccessListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)

        connectWithEmailButton = view.findViewById(R.id.auth_with_email) as Button
        connectWithPhoneNumber = view.findViewById(R.id.auth_with_phone) as Button
        connectWithGoogle = view.findViewById(R.id.auth_with_google) as Button

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        connectWithEmailButton.setOnClickListener{
            listener.onAuthorizationSuccess()
        }
    }
}