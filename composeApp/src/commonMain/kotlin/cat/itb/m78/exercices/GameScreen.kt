package cat.itb.m78.exercices

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.coroutines.*

data class Preguntas(
    val text: String,
    val respuestas: List<String>,
    val correct: String
)


val questions = listOf(
    Preguntas("¿Cuál de estos pokemon ha ganado más mundiales en VGC Masters Division?", listOf("Cresselia", "Rayquaza", "Heatran", "Mewtwo"), "Cresselia"),
    Preguntas("¿Cuál de estos pokemon no tiene la habilidad intimidación?", listOf("Incineroar", "Haxorus", "Luxray", "Mawile"), "Haxorus"),
    Preguntas("¿Qué pokemon de tipo bicho es el único que ha ganado el mundial?", listOf("Accelgor", "Volcarona", "Escavalier", "Mega Beedrill"), "Escavalier"),
    Preguntas("¿Cuál de estos pokemon no ha ganado ningún torneo oficial?", listOf("Clefairy", "Eevee", "Pikachu", "Cottonee"), "Pikachu"),
    Preguntas("¿Cuál de estos pokemon resiste el tipo hada?", listOf("Charizard", "Lucario", "Incineroar", "Todas las anteriores"), "Charizard"),
    Preguntas("¿Cuántos pokemon pseudo-legendarios (BST 600, segunda evolución) no son de tipo dragón?", listOf("4", "2", "1", "3"), "2"),
    Preguntas("¿Qué pokemon no tiene debilidades en la práctica?", listOf("Rotom Ventilador", "Zoroark de Hisui", "Elektross", "Spiritomb"), "Elektross"),
    Preguntas("¿Cuál de estos pokemon no evoluciona?", listOf("Carbink", "Dunsparce", "Poltchageist", "Sinistea"), "Carbink"),
    Preguntas("¿Cuántos PP como máximo puede tener Hiperrayo?", listOf("5", "16", "8", "10"), "8"),
    Preguntas("¿Qué grupo de pokemon no estaba en espada y escudo?", listOf("Los Regi", "Los Ultraentes", "Arceus y Darkrai", "Los Iniciales de Séptima Generación"), "Arceus y Darkrai"),
    Preguntas("¿De qué tipo es Mega Kangaskhan?", listOf("Normal", "Lucha", "Normal/Acero", "Normal/Lucha"), "Normal"),
    Preguntas("¿Cuánto aumentan la potencia de los movimientos de su tipo los campos psíquico, eléctrico y de hierba?", listOf("Un 10%", "Un 30%", "Un 50%", "Un 25%"), "Un 30%"),
    Preguntas("¿Qué recibe Dondozo al comerse a Tatsugiri?", listOf("Duplica todas sus estadísticas", "No puede cambiar", "Una mejora en uno de sus movimientos", "Todas las anteriores"), "Todas las anteriores"),
    Preguntas("¿Qué hace el tera estelar?", listOf("Potencia un movimiento de cada tipo una vez", "Cambia el tipo defensivo", "Hace que teraexplosión siempre haga supereficaz", "Todas las anteriores"), "Potencia un movimiento de cada tipo una vez"),
    Preguntas("¿Cuánta potencia base tiene erupción?", listOf("100", "120", "150", "200"), "150"),
)
class QuestionViewModel : ViewModel() {
    private val shuffledQuestions = questions.shuffled() // Mezcla las preguntas
    var i by mutableStateOf(0)
    var question by mutableStateOf(shuffledQuestions[i])
    var shuffledAnswers by mutableStateOf(shuffledQuestions[i].respuestas.shuffled())
    val counter = mutableStateOf(1)
    val correct = mutableStateOf(0)
    init {
        restart()
    }
    fun onAnswerSelected(selected: String): Boolean {
        val isCorrect = selected == question.correct
        if (isCorrect) {
            correct.value++

        }
        return if (i < questions.size - 1) {
            i++
            question = shuffledQuestions[i]
            shuffledAnswers = question.respuestas.shuffled()
            counter.value++
            false
        } else {
            i = 0
            counter.value = 1
            true
        }
    }
    fun restart() {
        i = 0
        question = shuffledQuestions[i]
        shuffledAnswers = question.respuestas.shuffled()
        counter.value = 1
        correct.value = 0
    }
}


@Composable
fun Question(gotoResults: (Int) -> Unit) {
    val viewModel = viewModel { QuestionViewModel() }
    GameScreen(
        viewModel.question,
        viewModel::onAnswerSelected,
        viewModel.counter.value
    ){
        gotoResults(viewModel.correct.value)
    }
}

@Composable
fun GameScreen(question: Preguntas,
               onAnswerSelected: (String) -> Boolean,
               counter: Int,
               gotoResults: ()-> Unit){

    val correctMsg = remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$counter/15")
            Text(text = question.text, style = MaterialTheme.typography.headlineMedium)
            Row {
                Button(
                    onClick = {
                        if (onAnswerSelected(question.respuestas[0])) {
                            gotoResults()
                        }
                        if (question.correct == question.respuestas[0]){
                            correctMsg.value = "Resposta correcta!"
                        }
                        else{
                            correctMsg.value = "Resposta incorrecta"
                        }
                    }
                ) {
                    Text(question.respuestas[0])
                }
                Button(
                    onClick = {
                        if (onAnswerSelected(question.respuestas[1])) {
                            gotoResults()
                        }
                        if (question.correct == question.respuestas[1]){
                            correctMsg.value = "Resposta correcta!"
                        }
                        else{
                            correctMsg.value = "Resposta incorrecta"
                        }
                    }
                ) {
                    Text(question.respuestas[1])
                }
            }
            Row {
                Button(
                    onClick = {
                        if (onAnswerSelected(question.respuestas[2])) {
                            gotoResults()
                        }
                        if (question.correct == question.respuestas[2]){
                            correctMsg.value = "Resposta correcta!"
                        }
                        else{
                            correctMsg.value = "Resposta incorrecta"
                        }
                    }
                ) {
                    Text(question.respuestas[2])
                }
                Button(
                    onClick = {
                        if (onAnswerSelected(question.respuestas[3])) {
                            gotoResults()
                        }
                        if (question.correct == question.respuestas[3]){
                            correctMsg.value = "Resposta correcta!"
                        }
                        else{
                            correctMsg.value = "Resposta incorrecta"
                        }
                    }
                ) {
                    Text(question.respuestas[3])
                }
            }
            Text(correctMsg.value)
        }
    }
}


