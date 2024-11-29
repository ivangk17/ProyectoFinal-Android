package com.example.login.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.login.R
import com.example.login.data.models.DrawerItems
import com.example.login.navigation.Rutas

@Composable
fun GetDrawerMenuItems(): List<DrawerItems> {
    val homeIcon = ImageVector.vectorResource(id = R.drawable.black_contour_home_icon)
    val solicitudesIcon = ImageVector.vectorResource(id = R.drawable.black_application_icon)
    val profileIcon = ImageVector.vectorResource(id = R.drawable.ic_profile)
   // val legalIcon = ImageVector.vectorResource(id = R.drawable.info_icon)

    return listOf(
        DrawerItems(homeIcon, stringResource(R.string.home_text), Rutas.HomeScreen.ruta),
        DrawerItems(solicitudesIcon, stringResource(R.string.solicitudes_text), Rutas.SolicitudesScreen.ruta),
        DrawerItems(profileIcon, "Perfil", Rutas.PerfilScreen.ruta),
    )
}