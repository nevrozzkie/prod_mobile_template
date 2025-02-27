package base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import view.colorScheme
import view.typography

@Composable
fun DefaultTopAppBar(

    title: String,
    navigation: @Composable () -> Unit = {},
    action: @Composable () -> Unit = {},
    bottomPadding: Dp = 0.dp,
    horizontalPaddings: Dp = 24.dp, //Paddings.hTopBar //TODO
    backgroundColor: Color = colorScheme.background,
    isCentre: Boolean = false,
    extraContent: @Composable () -> Unit
) {
    Column(
        Modifier.background(
            backgroundColor
        )
    ) {
        Row(
            Modifier
            .padding(top = 13.dp) //Paddings.medium //TODO
            .fillMaxWidth()
            .padding(horizontal = horizontalPaddings),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isCentre) Arrangement.SpaceBetween else Arrangement.Start
        ) {
            navigation()
            Text(
                title,
                style = typography.headlineLarge,
                modifier = Modifier
            )
            if (!isCentre) Spacer(Modifier.weight(1f))
            action()
        }
        extraContent()
        Spacer(Modifier.height(bottomPadding))
    }
}