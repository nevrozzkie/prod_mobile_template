package base

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import view.colorScheme
import view.shapes


@Composable
fun TonalCard(
    modifier: Modifier = Modifier,
    shape: Shape = shapes.large,
    elevation: Dp = 10.dp, //TODO
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val containerColor = colorScheme.surfaceColorAtElevation(elevation)
    TonalCard(
        modifier = modifier,
        shape = shape,
        containerColor = containerColor,
        onClick = onClick,
        content = content
    )
}

@Composable
fun TonalCard(
    modifier: Modifier = Modifier,
    shape: Shape = shapes.large,
    containerColor: Color = colorScheme.surfaceContainer,
    contentColor: Color = contentColorFor(containerColor),
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .then(
                if (onClick != null) Modifier.clip(shape).clickable {
                    onClick()
                }
                else Modifier
            ),
        shape = shape,
        color = containerColor,
        contentColor = contentColor
    ) {
        content()
    }
}

