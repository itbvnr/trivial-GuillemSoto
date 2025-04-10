package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.clefairy
import org.jetbrains.compose.resources.painterResource

@Composable
fun MenuScreen(onSettingsClick: () -> Unit, onQuestionClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(Res.drawable.clefairy),
                contentDescription = null
            )
            Button(onClick = { onQuestionClick() }){ Text("New Game") }
            Button(onClick = { onSettingsClick() }){ Text("Settings") }
        }
    }
}