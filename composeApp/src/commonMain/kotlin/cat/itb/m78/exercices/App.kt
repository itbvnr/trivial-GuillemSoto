package cat.itb.m78.exercices


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.theme.AppTheme

sealed interface Practica {
    object Students : Practica
    object Faltes : Practica
}
class PracticaViewModel : ViewModel() {
    val screenState = mutableStateOf<Practica>(Practica.Students)
    var faltes = mutableStateOf("")

    fun navigateTo(screen: Practica) {
        screenState.value = screen
    }

    /*fun setScore(newScore: Int) {
        score.value = newScore
    }*/
}
@Composable
fun App() = AppTheme {
    val viewModel = viewModel<PracticaViewModel>(   )
    val screen = viewModel.screenState.value
    when(screen) {
        Practica.Students -> StudentScreen(
            onFaltesClick = { viewModel.navigateTo(Practica.Faltes) },
            faltes = viewModel.faltes
        )
        Practica.Faltes -> FaltesScreen(
            onBackToStudents = { viewModel.navigateTo(Practica.Students) },
            faltes = viewModel.faltes
        )
    }

    /*when (screen) {
        Practica.Menu -> MenuScreen(
            onSettingsClick = { viewModel.navigateTo(Practica.Settings) },
            onQuestionClick = {viewModel.navigateTo(Practica.Question)}
        )

        Practica.Settings -> SettingsScreen(onBackToMenu = { viewModel.navigateTo(Practica.Menu) })
        Practica.Result -> ResultScreen(
            onBackToMenu = { viewModel.navigateTo(Practica.Menu) },
            score = viewModel.score.value
        )
        Practica.Question -> Question(gotoResults = { correctAnswers:Int ->
            viewModel.setScore(correctAnswers)
            viewModel.navigateTo(Practica.Result)})
    }*/
}
