package ru.pusdev.surfworkshop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

data class CustomShapes(
    val shapesProjectInfo: RoundedCornerShape = RoundedCornerShape(
        topStart = 4.dp,
        topEnd = 12.dp,
        bottomStart = 12.dp,
        bottomEnd = 12.dp
    )
)

val DefaultShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp)
)