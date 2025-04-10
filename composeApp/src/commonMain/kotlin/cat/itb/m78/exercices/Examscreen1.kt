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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.theme.AppTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.clefairy
import org.jetbrains.compose.resources.painterResource


@Composable
fun StudentScreen(onFaltesClick:()->Unit, faltes:MutableState<String>){
    Box(modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Text("+-------------------------------+\n|____| Laia Garcia Puig |\n||||laia.garcia@example.com|\n|||___||\n")
                Text("+-------------------------------+\n|____| Marc Martinez Roca |\n||||marc.martinez@example.com|\n|||___||\n")
            }
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = { faltes.value += "Laia Garcia: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
                Button(onClick = { faltes.value += "Marc Martinez: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
            }
            Row {
                Text("+-------------------------------+\n|____| Aina Lopez Ferrer |\n||||aina.lopez@example.com|\n|||___||\n")
                Text("+-------------------------------+\n|____| Pau Sanchez Vila |\n||||pau.sanchez@example.com|\n|||___||\n")
            }
            Row {
                Button(onClick = { faltes.value += "Aina Lopez: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
                Button(onClick = { faltes.value += "Pau Sanchez: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
            }
            Row {
                Text("+-------------------------------+\n|____| Clara Ribas Soler |\n||||clara.ribas@example.com|\n|||___||\n")
                Text("+-------------------------------+\n|____| Jan Bosch Serra |\n||||jan.bosch@example.com|\n|||___||\n")
            }
            Row {
                Button(onClick = { faltes.value += "Clara Ribas: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
                Button(onClick = { faltes.value += "Jan Bosch: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
            }
            Row {
                Text("+-------------------------------+\n|____| Núria Ferrer Vidal |\n||||nuria.ferrer@example.com|\n|||___||\n")
                Text("+-------------------------------+\n|____| Oriol Puig Costa |\n||||oriol.puig@example.com|\n|||___||\n")
            }
            Row{
                Button(onClick = { faltes.value += "Núria Ferrer: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
                Button(onClick = { faltes.value += "Oriol Puig: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
            }
            Row {
                Text("+-------------------------------+\n|____| Marina Gil Ruiz |\n||||marina.gil@example.com|\n|||___||\n")
                Text("+-------------------------------+\n|____| Alex Valls Pons |\n||||alex.valls@example.com|\n|||___||\n")
            }
            Row {
                Button(onClick = { faltes.value += "Marina Gil: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
                Button(onClick = { faltes.value += "Alex Valls: " + Clock.System.now() + "\n" }){ Text("Ha faltat") }
            }
            Button(onClick = { onFaltesClick() }){ Text("Faltes") }
        }
    }
}
