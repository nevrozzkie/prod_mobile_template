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
            else -> TODO()
        }
    }
}
