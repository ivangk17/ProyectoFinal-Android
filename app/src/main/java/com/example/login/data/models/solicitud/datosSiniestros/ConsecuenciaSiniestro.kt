package com.example.login.data.models.solicitud.datosSiniestros

data class ConsecuenciaSiniestro(
    var danioParcial: Boolean = false,
    var roboRueda: Boolean = false,
    var roboParcial: Boolean = false,
    var danioTerceros: Boolean = false,
    var incendioTotal: Boolean = false,
    var otros: Boolean = false,
    var destruccionTotal: Boolean = false,
    var roboTotal: Boolean = false,
    var roturaCristales: Boolean = false,
    var incendioParcial: Boolean = false,
)
