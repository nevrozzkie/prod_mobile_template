package auth

import com.arkivanov.mvikotlin.core.store.Reducer
import auth.AuthStore.State
import auth.AuthStore.Message

object AuthReducer : Reducer<State, Message> {
    override fun State.reduce(msg: Message): State {
        return when (msg) {
            else -> TODO()
        }
    }
}