package auth

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Key
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VpnKey
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import base.DefaultTextField
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import view.colorScheme
import view.shapes

data object SharedStates {
    const val TOP_FIELD = "topField"
    const val BOTTOM_FIELD = "bottomField"
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AuthScreen(component: AuthComponent) {
    val model by component.model.subscribeAsState()


    val columnModifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())

    SharedTransitionLayout {
        Column(
            modifier = Modifier
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AnimatedContent(model.destination) { targetState ->
                Column(
                    columnModifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    when (targetState) {

                        AuthStore.State.Destination.Login -> {
                            AuthLayout(
                                topContent = {
                                    Text("dsada", modifier = Modifier)
                                }
                            ) {
                                DefaultTextField(
                                    value = model.email,
                                    onValueChange = {
                                        component.onEvent(AuthStore.Intent.ChangeEmail(it))
                                    },
                                    placeholderText = "Почта",
                                    leadingIcon = Icons.Rounded.MailOutline,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .sharedBounds(
                                            sharedContentState = rememberSharedContentState(
                                                SharedStates.TOP_FIELD
                                            ),
                                            animatedVisibilityScope = this@AnimatedContent
                                        )
                                )

                                Spacer(Modifier.height(20.dp))
                                DefaultTextField(
                                    value = model.password,
                                    onValueChange = {
                                        component.onEvent(AuthStore.Intent.ChangePassword(it))
                                    },
                                    placeholderText = "Пароль",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .sharedBounds(
                                            sharedContentState = rememberSharedContentState(
                                                SharedStates.BOTTOM_FIELD
                                            ),
                                            animatedVisibilityScope = this@AnimatedContent
                                        ),
                                    leadingIcon = Icons.Rounded.VpnKey,
                                    trailingIcon = {
                                        IconButton(
                                            onClick = {

                                            }
                                        ) {
                                            Icon(Icons.Rounded.Visibility, null)
                                        }
                                    }
                                )
                                Spacer(Modifier.height(20.dp))
                                IconButton(
                                    onClick = {
                                        component.onEvent(
                                            AuthStore.Intent.ChangeDestination(
                                                AuthStore.State.Destination.Welcome
                                            )
                                        )
                                    }
                                ) {
                                    Icon(Icons.Rounded.ArrowBackIosNew, null)
                                }
                            }
                        }

                        AuthStore.State.Destination.Registration -> TODO()
                        AuthStore.State.Destination.Welcome -> {
                            Spacer(Modifier)
                            Text("Добро пожаловать!")
                            Column {
                                TextButton(
                                    onClick = {
                                        component.onEvent(
                                            AuthStore.Intent.ChangeDestination(
                                                AuthStore.State.Destination.Registration
                                            )
                                        )
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .sharedBounds(
                                            sharedContentState = rememberSharedContentState(
                                                SharedStates.TOP_FIELD
                                            ),
                                            animatedVisibilityScope = this@AnimatedContent
                                        ),
                                    shape = shapes.medium,
                                    colors = ButtonDefaults.textButtonColors(
                                        containerColor = colorScheme.primary.copy(alpha = .2f),
                                        contentColor = colorScheme.onSurface
                                    )
                                ) {
                                    Text(
                                        "Зарегистрироваться",
                                        modifier = Modifier.padding(vertical = 5.dp)
                                    )
                                }

                                Spacer(Modifier.height(20.dp))
                                Button(
                                    onClick = {
                                        component.onEvent(
                                            AuthStore.Intent.ChangeDestination(
                                                AuthStore.State.Destination.Login
                                            )
                                        )
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .sharedBounds(
                                            sharedContentState = rememberSharedContentState(
                                                SharedStates.BOTTOM_FIELD
                                            ),
                                            animatedVisibilityScope = this@AnimatedContent
                                        ),
                                    shape = shapes.medium
                                ) {
                                    Text(
                                        "Войти в аккаунт",
                                        modifier = Modifier.padding(vertical = 5.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}