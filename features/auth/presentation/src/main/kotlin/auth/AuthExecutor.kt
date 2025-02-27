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
            is Intent.ChangeAvatar -> TODO()
            is Intent.ChangeConfirmPassword -> TODO()
            is Intent.ChangeDestination -> TODO()
            is Intent.ChangeEmail -> TODO()
            is Intent.ChangeFirstName -> TODO()
            is Intent.ChangeLastName -> TODO()
            is Intent.ChangePassword -> TODO()
            is Intent.ClickAuth -> TODO()
        }
    }
}
