package base

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import base.layouts.ThreeComponentsLayout
import view.colorScheme
import view.compositionLocals.LocalViewManager
import view.compositionLocals.viewManagerState
import view.typography


data object DefaultBasicTextFieldDefaults {
    val placeholderColor
        @Composable get() = colorScheme.onSurface.copy(alpha = .6f)
}

@Composable
fun DefaultTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(15.dp),
    textStyle: TextStyle = typography.bodyLarge,
    placeholderText: String,
    placeholderAlignment: Alignment = Alignment.CenterStart,
    placeholderColor: Color = DefaultBasicTextFieldDefaults.placeholderColor,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: ImageVector? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    TonalCard(modifier = modifier) {
        ThreeComponentsLayout(
            modifier = Modifier.padding(contentPadding),
            paddingBetween = 10.dp,
            leftContent = {
                leadingIcon?.let {
                    Icon(
                        leadingIcon, "textFieldLeadingIcon",
                        tint = placeholderColor
                    )
                }
            },
            rightContent = {
                trailingIcon?.let {

                    CompositionLocalProvider(
                        LocalContentColor provides placeholderColor
                    ) {
                        Box(Modifier.size(24.dp)) {
                            trailingIcon()
                        }
                    }
                }
            },
            centerContent = {
                DefaultBasicTextField(
                    value,
                    onValueChange,
                    Modifier,
                    textStyle,
                    placeholderText,
                    placeholderAlignment,
                    placeholderColor,
                    visualTransformation,
                    keyboardActions,
                    keyboardOptions
                )
            }
        )

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DefaultBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = typography.bodyLarge,
    placeholderText: String,
    placeholderAlignment: Alignment = Alignment.CenterStart,
    placeholderColor: Color = DefaultBasicTextFieldDefaults.placeholderColor,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    BasicTextField(
        value = value,
        onValueChange = { text ->
            onValueChange(text)
        },
        modifier = modifier,
        textStyle = textStyle.copy(
            color = colorScheme.onSurface
        ),
        decorationBox = { innerTextField ->
            Box() {
                if (value.isEmpty()) {
                    Text(
                        text = placeholderText,
                        style = textStyle,
                        color = placeholderColor,
                        maxLines = 1,
                        modifier = Modifier.align(placeholderAlignment)
                    )
                }
                innerTextField()
            }
        },
        cursorBrush = SolidColor(colorScheme.primary),
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions
    )
}