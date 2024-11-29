package com.example.login.data.network.models

import com.example.login.data.models.Domicilio
import com.example.login.data.models.personas.user.Role
import com.google.gson.annotations.SerializedName

data class UserInfoResponse(

    val role: Role = Role.ASEGURADO,

    @SerializedName("_id")
    val id: String = "",

    @SerializedName("name")
    val nombre :String = "",

    @SerializedName("lastname")
    var apellido: String = "",

    @SerializedName("full_name")
    var nombreCompleto: String = "${nombre} ${apellido} ",

    @SerializedName("dni")
    var dni: Number = -1,

    var email: String = "",

    @SerializedName("phone")
    var telefono: Number = -1,

    @SerializedName("date_of_birth")
    var  fechaDeNacimiento: String = "",

    @SerializedName("gender")
    var sexo: String = "",

    @SerializedName("password")
    var password: String = "",

    @SerializedName("domicile")
    var domicilio: Domicilio = Domicilio()
)
