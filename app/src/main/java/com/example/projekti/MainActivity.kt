package com.example.projekti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.projekti.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the SharedPreferencesHelper
        sharedPreferencesHelper = SharedPreferencesHelper(this)

        // Retrieve the theme preference from SharedPreferences
        val theme = sharedPreferencesHelper.getThemePreference()

        // Apply the theme before setting the content view
        applyTheme(theme)

        // Inflate the layout and set the content view
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up NavHostFragment and NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

        // Set up BottomNavigationView with NavController
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    // Function to apply the theme based on the value
    private fun applyTheme(theme: String) {
        when (theme) {
            "light" -> setTheme(R.style.Theme_YourApp_Light)
            "dark" -> setTheme(R.style.Theme_YourApp_Dark)
            else -> setTheme(R.style.Theme_YourApp_Light)
        }
    }
}
