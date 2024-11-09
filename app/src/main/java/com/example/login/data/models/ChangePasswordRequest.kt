package com.example.login.data.models

data class ChangePasswordRequest(
    val oldPass: String,
    val newPass: String,
    val confirmPassword: String
)
