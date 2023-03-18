import androidx.compose.runtime.*
import counter.counter
import counter.counterModule
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

@JsModule("./styles.css")
external val cssFile: dynamic

val koin get() = GlobalContext.get()

// nice to use enums for qualifiers
enum class Qualifiers : Qualifier {
    Counter
    ;

    override val value = this.name
}


fun main() {

    startKoin {
        modules(counterModule)
    }

    renderComposable(rootElementId = "root") {
        Div({
            // tailwind integration works
            classes("container", "mx-auto", "px-4", "bg-gray-100")
        }) {

            P {
                Text("Oh Hai Compose")
            }
            counter()
        }
    }
}


