package ru.pusdev.surfworkshop.components.placeholder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@Composable
fun LoadingScreenState() {
    Box {
        CircularProgressIndicator(
            color = WorkshopTheme.defaultColors.primary,
            strokeWidth = 4.dp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}