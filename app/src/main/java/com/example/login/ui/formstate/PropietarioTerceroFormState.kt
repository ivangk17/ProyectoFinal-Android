package com.example.login.ui.formstate

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.login.data.models.fields.FormField
import com.example.login.data.models.fields.TipoCampo
import com.example.login.data.models.personas.Sexo
import com.example.login.data.models.vehiculos.ColorVehiculo
import com.example.login.data.models.vehiculos.TipoVehiculo

data class PropietarioTerceroFormState(
    var fechaNacimiento: MutableState<String?> = mutableStateOf(null),
    var errorFechaNacimiento: MutableState<String?> = mutableStateOf(null),
    var sexoSeleccionado: MutableState<Sexo> = mutableStateOf(Sexo.HOMBRE),
    var fechaDeVencimiento: MutableState<String?> = mutableStateOf(null),
    var errorFechaVencimiento: MutableState<String?> = mutableStateOf(null),
    var tipoVehiculo: MutableState<TipoVehiculo> = mutableStateOf(TipoVehiculo.AUTO),
    var colorDelVehiculo: MutableState<ColorVehiculo> = mutableStateOf(ColorVehiculo.Blanco),
     val campos: List<FormField> = listOf(
        FormField("Nombre", tipo = TipoCampo.TEXTO),
        FormField("Apellido", tipo = TipoCampo.TEXTO),
        FormField("Calle", tipo = TipoCampo.TEXTO),
        FormField("Numero", tipo = TipoCampo.NUMERICO),
        FormField("Piso", tipo = TipoCampo.NUMERICO),
        FormField("Departamento", tipo = TipoCampo.TEXTO),
        FormField("Codigo Postal", tipo = TipoCampo.CODIGO_POSTAL),
        FormField("DNI", tipo = TipoCampo.DNI),
        FormField("Email", tipo = TipoCampo.TEXTO),
        FormField("Telefono", tipo = TipoCampo.NUMERICO),


        FormField("Marca", tipo = TipoCampo.TEXTO),
        FormField("Modelo", tipo = TipoCampo.TEXTO),
        FormField("Año del auto", tipo = TipoCampo.NUMERICO),
        FormField("Dominio", tipo = TipoCampo.TEXTO),
        FormField("Aseguradora", tipo = TipoCampo.TEXTO),
        FormField("Poliza", tipo = TipoCampo.TEXTO),
    )
)

