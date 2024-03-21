package com.example.pizzadelivery.greeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pizzadelivery.R

class GreetingFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var joinButton: Button
    private lateinit var enterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_greeting, container, false)

        joinButton = view.findViewById(R.id.join_button) as Button
        enterButton = view.findViewById(R.id.enter_button) as Button

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        joinButton.setOnClickListener{ navController.navigate(R.id.action_greetingFragment_to_regFragment)}
        enterButton.setOnClickListener{ navController.navigate(R.id.action_greetingFragment_to_authFragment)}
    }
}