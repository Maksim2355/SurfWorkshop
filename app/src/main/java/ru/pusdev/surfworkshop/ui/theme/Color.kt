package ru.pusdev.surfworkshop.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

// Нейминг цветов https://www.color-blindness.com/color-name-hue

val DODGER_BLUE_23A3FF = Color(0xFF23A3FF)
val DODGER_BLUE_0094FF = Color(0xFF0094FF)

val YELLOW_ORANGE_FFA940 = Color(0xFFFFA940)
val YELLOW_ORANGE_F18C11 = Color(0xFFF18C11)

val LUCKY_POINT_252849 = Color(0xFF252849)

val LIME_GREEN_3DDB60 = Color(0xFF3DDB60)
val SPRING_GREEN_30C150 = Color(0xFF30C150)

val WILD_WATERMELON_FF5778 = Color(0xFFFF5778)
val TORCH_RED_FF5778 = Color(0xFFFF1744)

val SLATE_GRAY_7C7E92 = Color(0xFF7C7E92)
val SLATE_GRAY_7C7E92_72 = Color(0xB87C7E92)

val SOLITUDE_F6F7FA = Color(0xFFF6F7FA)

val BLACK_PEARL_10171D = Color(0xFF10171D)
val CINDER_22292E = Color(0xFF22292E)

val DarkColorPalette = darkColors(
    primary = DODGER_BLUE_23A3FF,
    background = BLACK_PEARL_10171D,
    surface = CINDER_22292E,
    onSurface = BLACK_PEARL_10171D
)

val LightColorPalette = lightColors(
    primary = DODGER_BLUE_0094FF,
    background = SOLITUDE_F6F7FA,
    surface = Color.White,
    onSurface = SOLITUDE_F6F7FA
)