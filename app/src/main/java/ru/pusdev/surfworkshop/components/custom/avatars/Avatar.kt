package ru.pusdev.surfworkshop.components.custom.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Avatar(photoUrl: String, radius: Dp, strokeWidth: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(strokeWidth)
            .width(radius)
            .background(
                color = WorkshopTheme.defaultColors.onSurface,
                shape = WorkshopTheme.defaultShapes.large
            )
    ) {
        Image(
            painter = rememberImagePainter(photoUrl),
            contentDescription = null,
            modifier = Modifier
                .size(radius - strokeWidth)
                .fillMaxSize()
                .clip(shape = WorkshopTheme.defaultShapes.large)
        )
    }
}