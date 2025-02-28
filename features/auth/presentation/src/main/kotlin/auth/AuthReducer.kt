package auth

import com.arkivanov.mvikotlin.core.store.Reducer
import auth.AuthStore.State
import auth.AuthStore.Message

object AuthReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State {
        return when (msg) {
            is Message.ChangeAvatar -> copy(avatar = msg.avatar)
            is Message.ChangeConfirmPassword -> copy(confirmPassword = msg.confirmPassword)
            is Message.ChangeDestination -> copy(destination = msg.destination)
            is Message.ChangeEmail -> copy(email = msg.email)
            is Message.ChangeFirstName -> copy(firstName = msg.firstName)
            is Message.ChangeLastName -> copy(lastName = msg.lastName)
            is Message.ChangePassword -> copy(password = msg.password)
        }
    }
}