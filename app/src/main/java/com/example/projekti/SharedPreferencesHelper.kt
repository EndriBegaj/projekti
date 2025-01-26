package com.example.projekti

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    fun getThemePreference(): String {
        // Fetch the theme stored in SharedPreferences, default is "light"
        return sharedPreferences.getString("theme", "light") ?: "light"
    }

    fun setThemePreference(theme: String) {
        // Save the selected theme to SharedPreferences
        sharedPreferences.edit().putString("theme", theme).apply()
    }
}
