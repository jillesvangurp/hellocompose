package components

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

@Composable
fun myButton(text: String, handler: (SyntheticMouseEvent) -> Unit) {
    Button({
        classes("bg-blue-500", "hover:bg-blue-700", "text-white", "font-bold", "py-2", "px-4", "rounded")
        onClick(handler)
    }) {
        Text(text)
    }
}

@Composable
fun row(
    gap: Double = 1.0,
    content: ContentBuilder<HTMLDivElement>? = null
) {
    Div({ classes("flex", "flex-row", "gap-$gap","content-center") }, content = content)
}
