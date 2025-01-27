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


        sharedPreferencesHelper = SharedPreferencesHelper(this)


        val theme = sharedPreferencesHelper.getThemePreference()


        applyTheme(theme)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }


    private fun applyTheme(theme: String) {
        when (theme) {
            "light" -> setTheme(R.style.Theme_YourApp_Light)
            "dark" -> setTheme(R.style.Theme_YourApp_Dark)
            else -> setTheme(R.style.Theme_YourApp_Light)
        }
    }
}
