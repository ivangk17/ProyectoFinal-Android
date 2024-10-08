package com.example.login.utilities

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class LastCharVisibleTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = if (text.text.isNotEmpty()) {
            "*".repeat(text.text.length - 1) + text.text.last()
        } else {
            ""
        }
        return TransformedText(AnnotatedString(transformedText), OffsetMapping.Identity)
    }
}