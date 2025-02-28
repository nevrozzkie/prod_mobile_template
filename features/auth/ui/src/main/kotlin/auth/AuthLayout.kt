package auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import base.DefaultTextField

@Composable
internal fun ColumnScope.AuthLayout(
    topContent: @Composable ColumnScope.() -> Unit,
    centerContent: @Composable ColumnScope.() -> Unit
) {
    Column(Modifier.weight(1f)) {
        topContent()
    }
    Column(Modifier.padding(horizontal = 10.dp).weight(1f)) {
        centerContent()
    }
    Spacer(Modifier.weight(.3f))
}