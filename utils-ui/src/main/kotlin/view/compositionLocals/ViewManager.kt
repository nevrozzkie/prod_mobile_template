package view.compositionLocals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import view.ThemeTint

data class ViewManager(
    val tint: ThemeTint,
    val isDark: Boolean = true
)

val LocalViewManager: ProvidableCompositionLocal<ViewManager> = staticCompositionLocalOf {
    error("No ViewManager provided")
}

// чтобы можно было редачить in any layer!
var viewManagerState by mutableStateOf(
    ViewManager(
        tint = ThemeTint.Auto,
        isDark = true
    )
)


fun initViewManager(themeTintName: String): ViewManager {
    return ViewManager(
        tint = getThemeTint(themeTintName)
    )
}

fun getThemeTint(themeTintName: String): ThemeTint = when (themeTintName) {
    ThemeTint.Dark.name -> ThemeTint.Dark
    ThemeTint.Light.name -> ThemeTint.Light
    else -> ThemeTint.Auto
}