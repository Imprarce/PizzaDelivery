package com.example.pizzadelivery.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.pizzadelivery.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)


        val navigationView = findViewById<NavigationView>(R.id.navigation_menu)
        navigationView.setNavigationItemSelectedListener(this)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MainPizzaFragment()).commit()
            navigationView.setCheckedItem(R.id.navigation_menu)
        }

        replaceFragment(MainPizzaFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu -> replaceFragment(MainPizzaFragment())
            R.id.stocks -> replaceFragment(StocksFragment())
            R.id.restaurants -> replaceFragment(RestaurantsFragment())
            R.id.personal_account -> replaceFragment(PersonalAccountFragment())
            R.id.favourites -> replaceFragment(FavouritesFragment())
            R.id.about_the_company -> replaceFragment((AboutTheCompanyFragment()))
            R.id.delivery -> replaceFragment(DeliveryFragment())
            R.id.support -> replaceFragment(SupportFragment())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment?) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}