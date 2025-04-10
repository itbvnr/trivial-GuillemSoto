package cat.itb.m78.exercices

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(onBackToMenu: () -> Unit, score: Int) {
    Box(modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Your Score: ", fontWeight = FontWeight.Black)
            Text(text = "$score/15")
            Button(onClick = { onBackToMenu() }){ Text("Back")}
        }
    }
}