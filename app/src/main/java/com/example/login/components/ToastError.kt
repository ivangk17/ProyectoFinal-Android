package com.example.login.components

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.example.login.R

@Composable
fun ToastError(context: Context, message: String) {
    val inflater = LayoutInflater.from(context)
    val layout = inflater.inflate(R.layout.custom_toast, null)

    val text: TextView = layout.findViewById(R.id.toast_text)
    text.text = message

    with (Toast(context)) {
        duration = Toast.LENGTH_SHORT
        view = layout
        show()
    }
}
