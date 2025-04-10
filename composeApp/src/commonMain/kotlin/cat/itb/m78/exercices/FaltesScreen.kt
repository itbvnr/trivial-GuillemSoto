package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.clefairy
import org.jetbrains.compose.resources.painterResource


@Composable
fun FaltesScreen(onBackToStudents: () -> Unit, faltes:MutableState<String>) {
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Text(faltes.value)
            Button(onClick = { onBackToStudents() }) {
                Text("Enrere")
            }
        }
    }
}