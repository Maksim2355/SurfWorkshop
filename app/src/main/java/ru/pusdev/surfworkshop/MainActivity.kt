package ru.pusdev.surfworkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.pusdev.surfworkshop.navigation.Routes
import ru.pusdev.surfworkshop.screens.MainScreen
import ru.pusdev.surfworkshop.screens.SplashScreen
import ru.pusdev.surfworkshop.ui.theme.DarkColorPalette
import ru.pusdev.surfworkshop.ui.theme.LightColorPalette
import ru.pusdev.surfworkshop.ui.theme.SurfWorkshopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkModeValue = isSystemInDarkTheme()
            val isDarkMode = remember { mutableStateOf(isDarkModeValue) }

            SurfWorkshopTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                // Чтобы не испольовать инцесты
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = if (isDarkMode.value) DarkColorPalette.background else LightColorPalette.background,
                        darkIcons = !isDarkMode.value
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.SPLASH_SCREEN
                    ) {
                        composable(Routes.SPLASH_SCREEN) {
                            SplashScreen {
                                navController.navigate(Routes.MAIN_SCREEN_ROUTE) {
                                    popUpTo(Routes.SPLASH_SCREEN) { inclusive = true }
                                }
                            }
                        }
                        composable(Routes.MAIN_SCREEN_ROUTE) {
                            MainScreen()
                        }
                        composable(Routes.DETAILS_PROJECTS_SCREEN) {

                        }
                        composable(Routes.DETAILS_EMPLOYEES_SCREEN) {

                        }
                    }
                }
            }
        }
    }
}
