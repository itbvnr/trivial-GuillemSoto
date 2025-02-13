package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Screen1(navigateToGameScreen: ()-> Unit, navigateToSettingScreen: ()-> Unit){
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            /*Image(

            )*/
            Button(onClick = navigateToGameScreen){ Text("New Game") }
            Button(onClick = navigateToSettingScreen){ Text("Settings") }
        }
    }
}