package com.example.pizzadelivery.greeting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.pizzadelivery.main.MainActivity
import com.example.pizzadelivery.R

class GreetingActivity : AppCompatActivity(), AuthFragment.OnAuthorizationSuccessListener{
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.greeting_main)

        val navHostFragment : NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment

        navController = navHostFragment.navController
    }

    @Override
    override fun onAuthorizationSuccess() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}