package view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import view.ThemeTint
import view.compositionLocals.ViewManager

@Composable
fun SystemBarsColorFix(viewManager: ViewManager) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = !isThemeDark(isDarkPriority = false, viewManager.tint),
        isNavigationBarContrastEnforced = false
    )
}