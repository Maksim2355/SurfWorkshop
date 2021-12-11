package ru.pusdev.surfworkshop.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import ru.pusdev.surfworkshop.components.custom.appbar.MainAppBar
import ru.pusdev.surfworkshop.navigation.Routes
import ru.pusdev.surfworkshop.ui.theme.CINDER_22292E
import ru.pusdev.surfworkshop.ui.theme.SLATE_GRAY_7C7E92
import ru.pusdev.surfworkshop.ui.theme.WorkshopTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WorkshopTheme.defaultColors.background)
    ) {
        MainAppBar {
            //TODO обработка нажатий по кнопке поиска
        }
        val pagerState = rememberPagerState(initialPage = 3)
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val tabs = listOf(
        "Сотрудники",
        "Проекты",
        "О приложении",
    )
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            //
        },
        divider = { },
        backgroundColor = WorkshopTheme.defaultColors.background
    ) {
        tabs.forEachIndexed { index, _ ->
            val isSelected = pagerState.currentPage == index
            Tab(
                text = {
                    Text(
                        text = tabs[index],
                        style = WorkshopTheme.typography.body1.copy(
                            color = if (isSelected) WorkshopTheme.defaultColors.primary else SLATE_GRAY_7C7E92
                        ),
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
