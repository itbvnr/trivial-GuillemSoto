package cat.itb.m78.exercices

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.*

data class Pregunta(val text: String, val answers: List<String>, val correct: String)


val questions = listOf(
    Pregunta("¿Cuál de estos pokemon ha ganado más mundiales en VGC Masters Division?", listOf("Cresselia", "Rayquaza", "Heatran", "Mewtwo"), "Cresselia"),
    Pregunta("¿Cuál de estos pokemon no tiene la habilidad intimidación?", listOf("Incineroar", "Haxorus", "Luxray", "Mawile"), "Haxorus"),
    Pregunta("¿Qué pokemon de tipo bicho es el único que ha ganado el mundial?", listOf("Accelgor", "Volcarona", "Escavalier", "Mega Beedrill"), "Escavalier"),
    Pregunta("¿Cuántos pokemon pseudo-legendarios (BST 600, segunda evolución) no son de tipo dragón?", listOf("4", "2", "1", "3"), "2"),

)

@Composable
fun GameScreen(navController: NavHostController){

    var question = remember { mutableStateOf( questions.random() ) }
    val score = remember { mutableStateOf(0) }
    val seconds = remember { mutableStateOf(60) }
    val rounds = remember { mutableStateOf(1) }
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = question.text, style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            question.answers.forEach { answer ->
                Button(
                    onClick = {
                        if (answer == question.correct) {
                            score.value += 1
                        }

                        LaunchedEffect(question) {
                            delay(1000L)
                            question = questions.random()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Text(text = answer)
                }
            }
//        Column {
//            Text("Time: "+ seconds.value + " seconds")
//            Text("Round: " + rounds.value+ "/5")
//            Text(text = question.text)
//            Box(modifier = Modifier.fillMaxSize()){
//                Column {
//                    Row {
//                        Button(onClick = { if(rounds.value==5){navController.navigate("ResultScreen")}else{rounds.value+=1} }) { Text("Answer1") }
//                        Button(onClick = { if(rounds.value==5){navController.navigate("ResultScreen")}else{rounds.value+=1} }) { Text("Answer2") }
//                    }
//                    Row {
//                        Button(onClick = { if(rounds.value==5){navController.navigate("ResultScreen")}else{rounds.value+=1} }) { Text("Answer3") }
//                        Button(onClick = { if(rounds.value==5){navController.navigate("ResultScreen")}else{rounds.value+=1} }) { Text("Answer4") }
//                    }
//                }
//            }
//        }
    }
}


