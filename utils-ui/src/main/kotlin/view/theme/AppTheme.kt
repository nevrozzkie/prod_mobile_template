package view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import view.ThemeTint
import view.compositionLocals.DarkThemedColors
import view.compositionLocals.LightThemedColors
import view.compositionLocals.LocalThemedColors
import view.compositionLocals.viewManagerState
import view.consts.DarkColorScheme
import view.consts.LightColorScheme
import view.consts.Typography
import view.consts.animated
import view.themedColors
import view.viewManager

@Composable
fun AppTheme(isDarkPriority: Boolean = false, content: @Composable () -> Unit) {

    viewManagerState = with(viewManagerState) {
        this.copy(
            isDark = isThemeDark(isDarkPriority, this.tint)
        )
    }

    val colorScheme = if (viewManager.isDark)
        DarkColorScheme else LightColorScheme


    val themedColors = if (viewManager.isDark)
        DarkThemedColors else LightThemedColors

    SystemBarsColorFix(viewManager)

    CompositionLocalProvider(
        LocalThemedColors provides themedColors,
        // fix xiaomi dark theme with dark color
        LocalContentColor provides colorScheme.onSurface
    ) {
        MaterialTheme(
            colorScheme = colorScheme.animated(),
            typography = Typography
        ) {
            content()
        }
    }
}

