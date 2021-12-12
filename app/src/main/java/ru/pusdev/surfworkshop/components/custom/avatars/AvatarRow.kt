package ru.pusdev.surfworkshop.components.custom.avatars

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AvatarRow(
    urls: List<String>,
    collapsingWidth: Dp = 6.dp,
    radius: Dp = 34.dp,
    strokeWidth: Dp = 2.dp
) {
    Row() {
        urls.forEach {
            Avatar(
                photoUrl = it,
                radius = radius,
                strokeWidth = strokeWidth,
                modifier = Modifier.padding(horizontal = -collapsingWidth)
            )
        }
    }

}