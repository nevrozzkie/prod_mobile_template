package com.prod2025.mobile_template.navigation.root

import auth.AuthComponent
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass


interface RootComponent : BackHandlerOwner {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class AuthChild(val component: AuthComponent) : Child()
    }


    @Serializable
    sealed interface Config {
        @Serializable
        data object Auth : Config
    }

    fun onBackClicked()

    fun onOutput(child: KClass<out Child>, config: Config)
}