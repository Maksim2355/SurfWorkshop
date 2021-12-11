package ru.pusdev.surfworkshop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.pusdev.surfworkshop.R


@Composable
fun SurfWorkshopTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (isDarkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val primaryTextColor = if (isDarkTheme) Color.White else LUCKY_POINT_252849
    val secondaryTextColor = if (isDarkTheme) Color.White.copy(alpha = 0.8f) else SLATE_GRAY_7C7E92

    val typography = Typography(
        h1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = primaryTextColor
        ),
        h2 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = primaryTextColor
        ),
        h3 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = secondaryTextColor
        ),
        subtitle1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = primaryTextColor
        ),
        subtitle2 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            color = secondaryTextColor
        ),
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = primaryTextColor
        ),
        button = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 17.sp
        ),
    )

    val images = WorkShopImage(
        splashIcon = if (isDarkTheme) R.drawable.ic_splash_logo_dark else R.drawable.ic_splash_logo_light,
        surfLogoIcon = if (isDarkTheme) R.drawable.ic_surf_dark else R.drawable.ic_surf_light,
        searchIcon = if (isDarkTheme) R.drawable.ic_search_dark else R.drawable.ic_search_light,
        arrowBackIcon = if (isDarkTheme) R.drawable.ic_arrow_back_dark else R.drawable.ic_arrow_back_light,
        callIcon = if (isDarkTheme) R.drawable.ic_call_dark else R.drawable.ic_call_light
    )
    CompositionLocalProvider(
        LocalAppDefaultColors provides colors,
        LocalAppTypography provides typography,
        LocalAppDefaultShape provides DefaultShapes,
        LocalAppCustomShape provides CustomShapes(),
        LocalAppImage provides images,
        content = content
    )
}