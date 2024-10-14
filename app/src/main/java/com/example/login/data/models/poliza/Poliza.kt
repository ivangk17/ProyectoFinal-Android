package com.example.login.data.models.poliza

import com.google.gson.annotations.SerializedName

data class Poliza(
    @SerializedName("_id")
    val id: String,
    val dominio: String

)

