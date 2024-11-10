package com.example.login.components.navigationdrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.login.data.models.DrawerItems


@Composable
fun DrawerItem(item: DrawerItems, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(vertical = 18.dp)
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.width(24.dp))
        Text(
            item.text,
            style = MaterialTheme.typography.bodyMedium
                .copy(
                    fontWeight = FontWeight.Bold
                ),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)

        )

    }
}

