package com.prod2025.mobile_template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.prod2025.mobile_template.navigation.root.RootComponentImpl
import com.prod2025.mobile_template.navigation.root.RootFlowScreen
import coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import view.compositionLocals.LocalViewManager
import view.compositionLocals.initViewManager
import view.compositionLocals.viewManagerState
import view.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(
                coreModule
            )
        }


        enableEdgeToEdge()

//        val prefs: SharedPreferences = Inject.instance()
//        val viewManager = getViewManager(prefs.getString(themeSettings, "Dark") ?: "Dark")

        viewManagerState = initViewManager("Dark")

        val rootComponent = RootComponentImpl(
            componentContext = defaultComponentContext(),
            storeFactory = DefaultStoreFactory(),
            activity = this
        )

        setContent {
            CompositionLocalProvider(
                LocalViewManager provides viewManagerState
            ) {
                AppTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RootFlowScreen(rootComponent)
                    }
                }
            }
        }
    }
}
