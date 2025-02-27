package view.compositionLocals

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import view.consts.Colors

data class ThemedColors(
    val green: Color,
)

val DarkThemedColors = ThemedColors(
    green = Colors.greenDarkPrimary
)

val LightThemedColors = ThemedColors(
    green = Colors.greenLightPrimary,
)

val LocalThemedColors: ProvidableCompositionLocal<ThemedColors> = staticCompositionLocalOf {
    error("No ThemedColors provided")
}
