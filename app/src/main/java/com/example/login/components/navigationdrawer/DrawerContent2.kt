package com.example.login.components.navigationdrawer

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.login.R
import com.example.login.data.models.DrawerItems
import com.example.login.utilities.GetDrawerMenuItems
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerContent2(
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
            DrawerItem(item=item)
            if (index < drawerItems.size - 1) {
                HorizontalDivider(
                    color = colorResource(R.color.teal_700),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}