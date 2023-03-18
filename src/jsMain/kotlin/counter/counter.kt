package counter

import Qualifiers
import androidx.compose.runtime.*
import components.myButton
import components.row
import koin
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.koin.dsl.module


val counterModule = module {
    single(Qualifiers.Counter) { mutableStateOf(0) }
}

@Composable
fun counter() {
    var counter by koin.get<MutableState<Int>>(Qualifiers.Counter)

    row {
        myButton("-") {
            counter -= 1
        }

        P {
            Text("$counter")
        }
        myButton("+") {
            counter += 1
        }
    }
}
