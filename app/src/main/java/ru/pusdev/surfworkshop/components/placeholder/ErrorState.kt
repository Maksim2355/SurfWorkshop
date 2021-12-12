package ru.pusdev.surfworkshop.components.placeholder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@Composable
fun ErrorScreenState(text: String = "Ошибка загрузки данных", onReplayClickAction: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(bottom = 16.dp),
            style = WorkshopTheme.typography.h2.copy(
                color = WorkshopTheme.defaultColors.error
            )
        )
        Button(
            onClick = { onReplayClickAction.invoke() },
            shape = WorkshopTheme.defaultShapes.large,
            modifier = Modifier.background(color = WorkshopTheme.defaultColors.primary)
        ) {

        }
    }
}