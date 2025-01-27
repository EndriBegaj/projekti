package com.example.projekti

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    fun getThemePreference(): String {

        return sharedPreferences.getString("theme", "light") ?: "light"
    }

    fun setThemePreference(theme: String) {

        sharedPreferences.edit().putString("theme", theme).apply()
    }
}
