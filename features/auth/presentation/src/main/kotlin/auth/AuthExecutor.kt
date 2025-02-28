package auth

import auth.AuthComponent.Output
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import auth.AuthStore.Intent
import auth.AuthStore.Label
import auth.AuthStore.State
import auth.AuthStore.Message

class AuthExecutor(
//    private val authRepository: AuthRepository = Inject.instance(),
    output: (Output) -> Unit
) : CoroutineExecutor<Intent, Unit, State, Message, Label>() {
    override fun executeIntent(intent: Intent) {
        when (intent) {
            is Intent.ChangeAvatar -> dispatch(Message.ChangeAvatar(intent.avatar))
            is Intent.ChangeConfirmPassword -> dispatch(Message.ChangeConfirmPassword(intent.confirmPassword))
            is Intent.ChangeDestination -> dispatch(Message.ChangeDestination(intent.destination))
            is Intent.ChangeEmail -> dispatch(Message.ChangeEmail(intent.email))
            is Intent.ChangeFirstName -> dispatch(Message.ChangeFirstName(intent.firstName))
            is Intent.ChangeLastName -> dispatch(Message.ChangeLastName(intent.lastName))
            is Intent.ChangePassword -> dispatch(Message.ChangePassword(intent.password))
            is Intent.ClickAuth -> TODO()
        }
    }
}
