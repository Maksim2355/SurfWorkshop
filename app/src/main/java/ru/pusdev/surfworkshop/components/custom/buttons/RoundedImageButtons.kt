package ru.pusdev.surfworkshop.components.custom.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@Composable
fun RoundedImageButton(imgRes: Int, imgDescription: String, onClickListener: () -> Unit) {
    Card(
        shape = WorkshopTheme.defaultShapes.medium,
        backgroundColor = WorkshopTheme.defaultColors.background,
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
    ) {
        Image(
            painter = painterResource(id = imgRes),
            contentDescription = imgDescription,
            modifier = Modifier
                .clickable { onClickListener.invoke() }
        )
    }

}