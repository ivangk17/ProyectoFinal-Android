package com.example.login.data.models

import com.google.gson.annotations.SerializedName

data class Domicilio(
    @SerializedName("adress")
    var calle: String = "",

    @SerializedName("locality")
    var localidad: String = "",

    @SerializedName("zip_code")
    var codigoPostal: String = "",

    @SerializedName("province")
    var provincia: String = "",

    @SerializedName("country")
    var pais: String = ""
)
