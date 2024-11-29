package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo
import com.example.login.data.models.vehiculos.UsoDelVehiculo

data class PropietarioAseguradoFormState(
    var commonFields: CommonFormFields = CommonFormFields(),
    val personaFormState: PersonaFormState = PersonaFormState(),
    val vehiculoFormState: VehiculoFormState = VehiculoFormState(),
    var usoDelVehiculo: MutableState<UsoDelVehiculo> = mutableStateOf(UsoDelVehiculo.PARTICULAR),
    var tipoVehiculo: MutableState<TipoVehiculo> = mutableStateOf(TipoVehiculo.AUTO),
    var colorDelVehiculo: MutableState<ColorVehiculo> = mutableStateOf(ColorVehiculo.Blanco),
    override  val campos: List<FormField> = listOf(
        FormField("Nombre", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Numero", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.CODIGO_POSTAL),
        FormField("DNI", tipo = TipoCampo.DNI),
        FormField("Email", tipo = TipoCampo.TEXTO),
        FormField("TEL", tipo = TipoCampo.TEXTO),
        FormField("Marca", tipo = TipoCampo.TEXTO),
        FormField("Modelo", tipo = TipoCampo.TEXTO),
        FormField("Año", tipo = TipoCampo.NUMERICO),
        FormField("Dominio", tipo = TipoCampo.TEXTO),
    )
): FormState

/*
 var usoDelVehiculo = mutableStateOf(UsoDelVehiculo.PARTICULAR)
    var poliza = Poliza()
    var user = mutableStateOf(UserInfoResponse())
    var sexoSeleccionado =  mutableStateOf(Sexo.HOMBRE)
    var colorDelVehiculo = mutableStateOf(ColorVehiculo.Blanco)
    var tipoVehiculo = mutableStateOf(TipoVehiculo.AUTO)
 */