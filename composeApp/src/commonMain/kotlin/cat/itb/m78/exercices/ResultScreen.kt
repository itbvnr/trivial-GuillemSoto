package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ResultScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Text("YourScore")
            //Variable con el score
        }
    }
}