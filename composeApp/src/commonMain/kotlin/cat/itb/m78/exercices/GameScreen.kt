package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.*

val questions = listOf(
    "Q1",
    "Q2",
    "Q3",
    "Q4"
)

@Composable
fun GameScreen(){

    val question = remember { mutableStateOf( questions.random() ) }
    val seconds = remember { mutableStateOf(60) }
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Text("Time: "+ seconds.value + " seconds")
            Text("Round 1/10")
            Text(question.value)
            Box(modifier = Modifier.fillMaxSize()){
                Column {
                    Row {
                        Button(onClick = { }) { Text("Answer1") }
                        Button(onClick = { }) { Text("Answer2") }
                    }
                    Row {
                        Button(onClick = { }) { Text("Answer3") }
                        Button(onClick = { }) { Text("Answer4") }
                    }
                }
            }
            //Slider
        }
    }
    while (seconds.value>0)
    {
        seconds.value -= seconds.value
        runBlocking {
            delay(1000)
        }
    }
}


