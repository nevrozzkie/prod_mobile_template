package auth

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.arkivanov.mvikotlin.core.store.StoreFactory
import auth.AuthStore.Intent
import auth.AuthStore.Label
import auth.AuthStore.State
import auth.AuthStore.Message

class AuthStoreFactory(
    private val storeFactory: StoreFactory,
    private val executor: AuthExecutor
) {

    fun create(): AuthStore {
        return AuthStoreImpl()
    }

    private inner class AuthStoreImpl :
        AuthStore,
        Store<Intent, State, Label> by storeFactory.create(
            name = "AuthStore",
            initialState = State(
                email = "",
                firstName = "",
                lastName = "",
                password = "",
                confirmPassword = "",
                destination = State.Destination.Welcome
            ),
            executorFactory = ::executor,
            reducer = AuthReducer
        )
}