package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import m78exercices.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun MenuScreen(navController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Column {
//            Image(
//                painter = painterResource(Res.drawable.clefairy),
//                contentDescription = null
//            )
            Button(onClick = { navController.navigate("GameScreen") }){ Text("New Game") }
            Button(onClick = { navController.navigate("SettingScreen") }){ Text("Settings") }
        }
    }
}