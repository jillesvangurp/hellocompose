import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable

@JsModule("./styles.css")
external val cssFile: dynamic

fun main() {
    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div({
            classes("container", "mx-auto", "bg-cyan-900")
        }) {
            P {
                Text("Oh Hai")
            }
            Div({ style { padding(25.px) } }) {
                Button(attrs = {
                    onClick { count -= 1 }
                }) {
                    Text("-")
                }

                Span({ style { padding(15.px) } }) {
                    Text("$count")
                }

                Button(attrs = {
                    onClick { count += 1 }
                }) {
                    Text("+")
                }
            }
        }
    }
}