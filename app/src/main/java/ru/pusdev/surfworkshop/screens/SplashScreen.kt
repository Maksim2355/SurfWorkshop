package ru.pusdev.surfworkshop.screens

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.pusdev.surfworkshop.R
import ru.pusdev.surfworkshop.navigation.Routes
import ru.pusdev.surfworkshop.navigation.Routes.MAIN_SCREEN_ROUTE
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@Composable
fun SplashScreen(onDelayListener: () -> Unit) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = Unit,
        block = {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            delay(1000)
            onDelayListener()
        }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WorkshopTheme.defaultColors.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(WorkshopTheme.images.splashIcon),
            alignment = Alignment.Center,
            contentDescription = "Icon splash",
            modifier = Modifier
                .height(420.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .scale(scale.value)
        )
        Box(modifier = Modifier.alpha(0.1f)) {
            Text("Дайте деняк")
        }
    }
}