package auth

import auth.AuthStore.Intent
import auth.AuthStore.Label
import auth.AuthStore.State
import com.arkivanov.mvikotlin.core.store.Store

interface AuthStore : Store<Intent, State, Label> {
    data class State(
        val email: String,
        val firstName: String,
        val lastName: String,
        val password: String,
        val confirmPassword: String,
        val destination: Destination,
        val avatar: ByteArray? = null,
    ) {
        sealed interface Destination {
            data object Welcome : Destination
            data object Registration : Destination
            data object Login : Destination
        }
    }

    sealed interface Intent {
        data class ChangeDestination(val destination: State.Destination) : Intent

        data class ChangeEmail(val email: String) : Intent
        data class ChangeFirstName(val firstName: String) : Intent
        data class ChangeLastName(val lastName: String) : Intent
        data class ChangePassword(val password: String) : Intent
        data class ChangeConfirmPassword(val confirmPassword: String) : Intent
        data class ChangeAvatar(val avatar: ByteArray) : Intent

        data object ClickAuth : Intent
    }

    sealed interface Message {
        data class ChangeDestination(val destination: State.Destination) : Message

        data class ChangeEmail(val email: String) : Message
        data class ChangeFirstName(val firstName: String) : Message
        data class ChangeLastName(val lastName: String) : Message
        data class ChangePassword(val password: String) : Message
        data class ChangeConfirmPassword(val confirmPassword: String) : Message
        data class ChangeAvatar(val avatar: ByteArray) : Message
    }

    sealed interface Label

}
