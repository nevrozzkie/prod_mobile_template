package auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import decompose.DefaultMVIComponent
import koin.Inject

class AuthComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    output: (Output) -> Unit
) : ComponentContext by componentContext,
    DefaultMVIComponent<AuthStore.Intent, AuthStore.State, AuthStore.Label> {

    private val factory = AuthStoreFactory(
        storeFactory = storeFactory,
        executor = AuthExecutor(output)
    )


    override val store: AuthStore
        get() = instanceKeeper.getStore() {
            factory.create()
        }

    sealed class Output {
        data object NavigateToMainFlow : Output()
    }

}