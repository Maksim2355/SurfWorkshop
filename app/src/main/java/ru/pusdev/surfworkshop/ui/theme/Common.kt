package ru.pusdev.surfworkshop.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object WorkshopTheme {
    val defaultColors: Colors
        @Composable
        get() = LocalAppDefaultColors.current

    val typography: Typography
        @Composable
        get() = LocalAppTypography.current

    val defaultShapes: Shapes
        @Composable
        get() = LocalAppDefaultShape.current

    val customShapes: CustomShapes
        @Composable
        get() = LocalAppCustomShape.current

    val images: WorkShopImage
        @Composable
        get() = LocalAppImage.current
}

val LocalAppDefaultColors = staticCompositionLocalOf<Colors> {
    error("No colors provided")
}

val LocalAppTypography = staticCompositionLocalOf<Typography> {
    error("No font provided")
}

val LocalAppDefaultShape = staticCompositionLocalOf<Shapes> {
    error("No shapes provided")
}

val LocalAppCustomShape = staticCompositionLocalOf<CustomShapes> {
    error("No shapes provided")
}

val LocalAppImage = staticCompositionLocalOf<WorkShopImage> {
    error("No images provided")
}