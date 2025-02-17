package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun SettingsScreen(navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Row {
                Text("Difficulty")
                //Desplegable amb les dificultats
            }
            Row {
                Text("Rounds")
                Column {
                    Button(onClick = { }) { Text("5") }
                    Button(onClick = { }) { Text("10") }
                    Button(onClick = { }) { Text("15") }
                }
            }
            Row {
                Text("Time per round")
                //Barra per ajustar temps
            }
            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}