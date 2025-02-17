package cat.itb.m78.exercices


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.theme.AppTheme
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Composable
internal fun App() = AppTheme {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MenuScreen") {
        composable("MenuScreen") { MenuScreen(navController) }
        composable("GameScreen") { GameScreen(navController) }
        composable("SettingScreen") { SettingsScreen(navController) }
        composable("ResultScreen") { ResultScreen(navController) }
    }
}
