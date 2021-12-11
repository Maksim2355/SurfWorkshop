package ru.pusdev.surfworkshop.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import ru.pusdev.surfworkshop.components.custom.appbar.MainAppBar
import ru.pusdev.surfworkshop.screens.about.AboutAppTab
import ru.pusdev.surfworkshop.screens.projects.ProjectsTab
import ru.pusdev.surfworkshop.ui.theme.SLATE_GRAY_7C7E92
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WorkshopTheme.defaultColors.background)
    ) {
        MainAppBar {
            //TODO обработка нажатий по кнопке поиска
        }
        val pagerState = rememberPagerState()
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val tabs = listOf(
        "СОТРУДНИКИ",
        "ПРОЕКТЫ",
        "О ПРИЛОЖЕНИИ",
    )
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 20.dp,
        indicator = @Composable { tabPositions ->
            Box(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            ) {
                Box(
                    Modifier
                        .width(24.dp)
                        .height(3.dp)
                        .background(
                            WorkshopTheme.defaultColors.primary,
                            shape = WorkshopTheme.defaultShapes.small
                        )
                        .align(Alignment.BottomCenter)
                )
            }
        },
        divider = { },
        backgroundColor = WorkshopTheme.defaultColors.background,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        tabs.forEachIndexed { index, _ ->
            val isSelected = pagerState.currentPage == index
            Tab(
                text = {
                    Text(
                        text = tabs[index],
                        style = WorkshopTheme.typography.body1.copy(
                            color = if (isSelected) WorkshopTheme.defaultColors.primary else SLATE_GRAY_7C7E92,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}


@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
        count = 3
    ) { page ->
        when (page) {
            0 -> EmployeesTab()
            1 -> ProjectsTab()
            2 -> AboutAppTab()
        }
    }
}
