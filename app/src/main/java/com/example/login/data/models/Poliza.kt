package com.example.login.data.models

import com.google.gson.annotations.SerializedName

data class Poliza(
    @SerializedName("_id")
    val id: String,
    val dominio: String

)

