package com.example.simplesharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class MySharedPref(context: Context) {

    private val sharedPreferences : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveString(key:String,value:String){
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}