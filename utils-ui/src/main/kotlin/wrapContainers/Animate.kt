package wrapContainers

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun animate(
    animationSpec: AnimationSpec<Color> = remember { spring(stiffness = Spring.StiffnessLow) },
    color: () -> Color
): Color {
    return animateColorAsState(color(), animationSpec, label = "colorAnimation").value
}