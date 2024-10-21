package com.example.login.data.network.models

import com.example.login.data.models.Domicilio
import com.example.login.data.models.personas.user.Role
import com.google.gson.annotations.SerializedName

data class UserInfoResponse(

    val role: Role,

    @SerializedName("name")
    val nombre :String,

    @SerializedName("lastname")
    var apellido: String,

    var nombreCompleto: String = "${nombre} ${apellido} ",

    @SerializedName("dni")
    var cuit: String,

    var email: String,

    @SerializedName("phone")
    var telefono: String,

    @SerializedName("date_of_birth")
    var  fechaDeNacimiento: String,

    @SerializedName("gender")
    var sexo: String,

    @SerializedName("domicile")
    var domicilio: Domicilio
)
