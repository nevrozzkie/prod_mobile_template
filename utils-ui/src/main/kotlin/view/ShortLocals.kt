package view

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import view.compositionLocals.LocalThemedColors
import view.compositionLocals.LocalViewManager
import view.compositionLocals.ThemedColors
import view.compositionLocals.ViewManager


val themedColors: ThemedColors
    @Composable @ReadOnlyComposable get() = LocalThemedColors.current

val viewManager: ViewManager
    @Composable @ReadOnlyComposable get() = LocalViewManager.current

val colorScheme: ColorScheme
    @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

val shapes: Shapes
    @Composable @ReadOnlyComposable get() = MaterialTheme.shapes

val typography: Typography
    @Composable @ReadOnlyComposable get() = MaterialTheme.typography

