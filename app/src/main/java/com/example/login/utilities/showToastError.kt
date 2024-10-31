package com.example.login.utilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.login.R

fun showToastError(context: Context, message: String) {
    val inflater = LayoutInflater.from(context)
    val layout: View = inflater.inflate(R.layout.custom_toast, null)

    val text: TextView = layout.findViewById(R.id.toast_text)
    text.text = message

    with(Toast(context)) {
        duration = Toast.LENGTH_SHORT
        view = layout
        show()
    }
}