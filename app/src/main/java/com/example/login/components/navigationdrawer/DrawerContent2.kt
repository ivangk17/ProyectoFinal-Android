package com.example.login.components.navigationdrawer

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.components.AppButton
import com.example.login.navigation.AppNavigationActions
import com.example.login.utilities.GetDrawerMenuItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerContent2(
    navigationActions: AppNavigationActions,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    val drawerItems = GetDrawerMenuItems()



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        drawerItems.forEachIndexed { index, item ->
            DrawerItem(item = item) {
                scope.launch {
                    navigationActions.navigateToRoute(item.route)
                    drawerState.close()
                }
            }

            if (index < drawerItems.size - 1) {
                HorizontalDivider(
                    color = colorResource(R.color.teal_700),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        AppButton(
            stringResource(
                R.string.log_out_text
            ),
            modifier = Modifier.padding(5.dp)
        ) {
            scope.launch {
                navigationActions.navigateToLogin()
                drawerState.close()
            }
        }
    }

}