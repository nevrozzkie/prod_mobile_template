package view.consts

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import wrapContainers.animate



val LightColorScheme = ColorScheme(
    primary = Color(0xFFFFEB3B), // Yellow 600
    onPrimary = Color(0xFF212121), // Black
    primaryContainer = Color(0xFFF9A825), // Yellow 800
    onPrimaryContainer = Color(0xFFFFFFFF), // White
    inversePrimary = Color(0xFFFFF176), // Yellow 300
    secondary = Color(0xFF64B5F6), // Blue 300
    onSecondary = Color(0xFFFFFFFF), // White
    secondaryContainer = Color(0xFFBBDEFB), // Blue 100
    onSecondaryContainer = Color(0xFF212121), // Black
    tertiary = Color(0xFF81C784), // Green 300
    onTertiary = Color(0xFFFFFFFF), // White
    tertiaryContainer = Color(0xFFC8E6C9), // Green 100
    onTertiaryContainer = Color(0xFF212121), // Black
    background = Color(0xFFFAFAFA), // Light Gray
    onBackground = Color(0xFF212121), // Black
    surface = Color(0xFFFAFAFA), // White
    onSurface = Color(0xFF212121), // Black
    surfaceVariant = Color(0xFFEEEEEE), // Light Gray
    onSurfaceVariant = Color(0xFF757575), // Gray
    surfaceTint = Color(0xFFF9A825), // Yellow 800
    inverseSurface = Color(0xFF212121), // Black
    inverseOnSurface = Color(0xFFFFFFFF), // White
    error = Color(0xFFE53935), // Red 600
    onError = Color(0xFFFFFFFF), // White
    errorContainer = Color(0xFFFFCDD2), // Red 100
    onErrorContainer = Color(0xFF212121), // Black
    outline = Color(0xFFBDBDBD), // Gray 400
    outlineVariant = Color(0xFFEEEEEE), // Light Gray
    scrim = Color(0x99000000), // Black with 60% opacity
    surfaceBright = Color(0xFFFFFFFF), // White
    surfaceDim = Color(0xFFF5F5F5), // Light Gray
    surfaceContainer = Color(0xFFEEEEEE), // Light Gray
    surfaceContainerHigh = Color(0xFFE0E0E0), // Gray 200
    surfaceContainerHighest = Color(0xFFBDBDBD), // Gray 400
    surfaceContainerLow = Color(0xFFF5F5F5), // Light Gray
    surfaceContainerLowest = Color(0xFFFFFFFF) // White
)

// Dark Colors
val DarkColorScheme = ColorScheme(
    primary = Color(0xFFFFEB3B), // Yellow 600
    onPrimary = Color(0xFF212121), // Black
    primaryContainer = Color(0xFFF9A825), // Yellow 800
    onPrimaryContainer = Color(0xFFFFFFFF), // White
    inversePrimary = Color(0xFFF9A825), // Yellow 800
    secondary = Color(0xFF42A5F5), // Blue 400
    onSecondary = Color(0xFF212121), // Black
    secondaryContainer = Color(0xFF64B5F6), // Blue 300
    onSecondaryContainer = Color(0xFFFFFFFF), // White
    tertiary = Color(0xFF66BB6A), // Green 400
    onTertiary = Color(0xFF212121), // Black
    tertiaryContainer = Color(0xFF81C784), // Green 300
    onTertiaryContainer = Color(0xFFFFFFFF), // White
    background = Color(0xFF121212), // Dark Gray
    onBackground = Color(0xFFFFFFFF), // White
    surface = Color(0xFF121212), // Dark Gray
    onSurface = Color(0xFFFFFFFF), // White
    surfaceVariant = Color(0xFF2E2E2E), // Dark Gray
    onSurfaceVariant = Color(0xFFBDBDBD), // Gray 400
    surfaceTint = Color(0xFFFFEB3B), // Yellow 600
    inverseSurface = Color(0xFFFFFFFF), // White
    inverseOnSurface = Color(0xFF212121), // Black
    error = Color(0xFFEF5350), // Red 400
    onError = Color(0xFF212121), // Black
    errorContainer = Color(0xFFE53935), // Red 600
    onErrorContainer = Color(0xFFFFFFFF), // White
    outline = Color(0xFF757575), // Gray 600
    outlineVariant = Color(0xFF424242), // Dark Gray
    scrim = Color(0x99000000), // Black with 60% opacity
    surfaceBright = Color(0xFF2E2E2E), // Dark Gray
    surfaceDim = Color(0xFF121212), // Dark Gray
    surfaceContainer = Color(0xFF1E1E1E), // Dark Gray
    surfaceContainerHigh = Color(0xFF2E2E2E), // Dark Gray
    surfaceContainerHighest = Color(0xFF424242), // Dark Gray
    surfaceContainerLow = Color(0xFF1E1E1E), // Dark Gray
    surfaceContainerLowest = Color(0xFF121212) // Dark Gray
)



@Composable
fun ColorScheme.animated(animationSpec: AnimationSpec<Color> = remember { spring(stiffness = Spring.StiffnessLow) }): ColorScheme {
    return this.copy(
        primary = animate(animationSpec) { this.primary },
        primaryContainer = animate(animationSpec) { this.primaryContainer },
        secondary = animate(animationSpec) { this.secondary },
        secondaryContainer = animate(animationSpec) { this.secondaryContainer },
        tertiary = animate(animationSpec) { this.tertiary },
        tertiaryContainer = animate(animationSpec) { this.tertiaryContainer },
        background = animate(animationSpec) { this.background },
        surface = animate(animationSpec) { this.surface },
        surfaceTint = animate(animationSpec) { this.surfaceTint },
        surfaceBright = animate(animationSpec) { this.surfaceBright },
        surfaceDim = animate(animationSpec) { this.surfaceDim },
        surfaceContainer = animate(animationSpec) { this.surfaceContainer },
        surfaceContainerHigh = animate(animationSpec) { this.surfaceContainerHigh },
        surfaceContainerHighest = animate(animationSpec) { this.surfaceContainerHighest },
        surfaceContainerLow = animate(animationSpec) { this.surfaceContainerLow },
        surfaceContainerLowest = animate(animationSpec) { this.surfaceContainerLowest },
        surfaceVariant = animate(animationSpec) { this.surfaceVariant },
        error = animate(animationSpec) { this.error },
        errorContainer = animate(animationSpec) { this.errorContainer },
        onPrimary = animate(animationSpec) { this.onPrimary },
        onPrimaryContainer = animate(animationSpec) { this.onPrimaryContainer },
        onSecondary = animate(animationSpec) { this.onSecondary },
        onSecondaryContainer = animate(animationSpec) { this.onSecondaryContainer },
        onTertiary = animate(animationSpec) { this.onTertiary },
        onTertiaryContainer = animate(animationSpec) { this.onTertiaryContainer },
        onBackground = animate(animationSpec) { this.onBackground },
        onSurface = animate(animationSpec) { this.onSurface },
        onSurfaceVariant = animate(animationSpec) { this.onSurfaceVariant },
        onError = animate(animationSpec) { this.onError },
        onErrorContainer = animate(animationSpec) { this.onErrorContainer },
        inversePrimary = animate(animationSpec) { this.inversePrimary },
        inverseSurface = animate(animationSpec) { this.inverseSurface },
        inverseOnSurface = animate(animationSpec) { this.inverseOnSurface },
        outline = animate(animationSpec) { this.outline },
        outlineVariant = animate(animationSpec) { this.outlineVariant },
        scrim = animate(animationSpec) { this.scrim },
    )
}