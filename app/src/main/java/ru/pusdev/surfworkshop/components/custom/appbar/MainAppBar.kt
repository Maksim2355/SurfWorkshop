package ru.pusdev.surfworkshop.components.custom.appbar

import android.os.WorkSource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.pusdev.surfworkshop.R
import ru.pusdev.surfworkshop.components.AppBarContainer
import ru.pusdev.surfworkshop.components.custom.buttons.RoundedImageButton
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@Composable
fun MainAppBar(onSearchClick: () -> Unit) {
    AppBarContainer(
        leftContent = {
            Image(
                painter = painterResource(id = WorkshopTheme.images.surfLogoIcon),
                contentDescription = WorkshopTheme.images.surfLogoDescription
            )
        }, rightContent = {
            RoundedImageButton(
                WorkshopTheme.images.searchIcon,
                WorkshopTheme.images.searchDescription
            ) { onSearchClick.invoke() }
        }
    )
}