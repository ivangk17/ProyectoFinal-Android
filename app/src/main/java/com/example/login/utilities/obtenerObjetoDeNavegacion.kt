package com.example.login.utilities

import androidx.navigation.NavBackStackEntry
import com.google.gson.Gson


    inline fun <reified T> obtenerObjetoDeNavegacion(
        backStackEntry: NavBackStackEntry,
        argName: String
    ): T? {
        val gson = Gson()
        val json = backStackEntry.arguments?.getString(argName) ?: return null
        return gson.fromJson(json, T::class.java)
    }
