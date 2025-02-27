package auth

import com.arkivanov.mvikotlin.core.store.Store
import auth.AuthStore.Intent
import auth.AuthStore.Label
import auth.AuthStore.State

interface AuthStore : Store<Intent, State, Label> {
    data class State(
        val dummy: String = "dummy"
    )

    sealed interface Intent

    sealed interface Message

    sealed interface Label

}
