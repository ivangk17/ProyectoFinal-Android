package com.example.login.utilities

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login.R
import com.example.login.data.models.DrawerItems

import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.res.vectorResource

@Composable
fun GetDrawerMenuItems(): List<DrawerItems> {
    val homeIcon = ImageVector.vectorResource(id = R.drawable.home_icon)
    val solicitudesIcon = ImageVector.vectorResource(id = R.drawable.application_icon)
    val legalIcon = ImageVector.vectorResource(id = R.drawable.info_icon)

    return listOf(
        DrawerItems(homeIcon, stringResource(R.string.home_text)),
        DrawerItems(solicitudesIcon, stringResource(R.string.solicitudes_text)),
        DrawerItems(legalIcon, stringResource(R.string.legal_text))
    )
}