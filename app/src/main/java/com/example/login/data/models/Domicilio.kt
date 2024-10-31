package com.example.login.data.models

import com.google.gson.annotations.SerializedName

data class Domicilio(
    @SerializedName("address")
    var calle: String = "",

    @SerializedName("number")
    var numero: Int = -1,

    @SerializedName("floor")
    var piso: Int? = null,

    @SerializedName("apartment")
    var departamento: String?= null,

    @SerializedName("zip_code")
    var codigoPostal: Int = -1,

)