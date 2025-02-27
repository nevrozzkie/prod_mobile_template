package auth

import com.arkivanov.mvikotlin.core.store.Reducer
import auth.AuthStore.State
import auth.AuthStore.Message

object AuthReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State {
        return when (msg) {
            is Message.ChangeAvatar -> TODO()
            is Message.ChangeConfirmPassword -> TODO()
            is Message.ChangeDestination -> TODO()
            is Message.ChangeEmail -> TODO()
            is Message.ChangeFirstName -> TODO()
            is Message.ChangeLastName -> TODO()
            is Message.ChangePassword -> TODO()
        }
    }
}