package com.example.login.data.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


data class TopBarConfig(
    val title: String,
    val titleStyle: TextStyle,
    val titleColor: Color,
    val topBarColor: Color,
    val showMenuIcon: Boolean
)

fun getTopBarConfig(
    title: String,
    titleStyle: TextStyle,
    titleColor: Color,
    topBarColor: Color,
    showMenuIcon: Boolean
): TopBarConfig {
    return TopBarConfig(
        title = title,
        titleStyle = titleStyle,
        titleColor = titleColor,
        topBarColor = topBarColor,
        showMenuIcon = showMenuIcon
    )
}