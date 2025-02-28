package com.prod2025.mobile_template.navigation.root

import android.graphics.Bitmap
import androidx.activity.ComponentActivity
import auth.AuthComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.active
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.items
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.prod2025.mobile_template.navigation.root.RootComponent.Child
import com.prod2025.mobile_template.navigation.root.RootComponent.Config
import com.prod2025.mobile_template.navigation.root.RootComponent.Config.*
import java.io.ByteArrayOutputStream
import kotlin.reflect.KClass

class RootComponentImpl(
    private val activity: ComponentActivity,
    componentContext: ComponentContext,
    private val storeFactory: StoreFactory
) : RootComponent, ComponentContext by componentContext {
    private val nav = StackNavigation<Config>()

    private val _stack = childStack(
        source = nav,
        serializer = Config.serializer(),
        initialConfiguration = Auth,
        childFactory = ::child,
    )

    override val stack = _stack

    private fun child(config: Config, childContext: ComponentContext): Child =
        when (config) {
            Auth -> Child.AuthChild(
                AuthComponent(
                    componentContext = childContext,
                    storeFactory = storeFactory,
                    output = ::onAuthOutput
                )
            )
        }

    private fun onAuthOutput(
        output: AuthComponent.Output
    ): Unit = when(output) {
        AuthComponent.Output.NavigateToMainFlow -> {
            TODO()
        }
    }


    override fun onBackClicked() {
        popOnce(child = stack.active.instance::class)
    }

    private fun popOnce(
        child: KClass<out Child>
    ) {
        val currentConfig = stack.active.configuration
        if (currentConfig is Config.Auth)
            activity.finish()
        else
            nav.pop()

    }

    override fun onOutput(child: KClass<out Child>, config: Config) {
        val existingConfig = stack.items.firstOrNull { child.isInstance(it.instance) }?.configuration
        nav.pushToFront(existingConfig ?: config)
    }
}