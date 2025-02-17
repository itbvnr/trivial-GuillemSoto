package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ResultScreen(navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Text("5")
        }
    }
}