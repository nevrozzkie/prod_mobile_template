package auth.remote

import io.ktor.client.HttpClient

class AuthRemoteDataSource(
    private val httpClientAuth: HttpClient,
) {


    private companion object {
        const val PRE_PATH = "/api/user"

        const val SIGN_IN_PATH = "$PRE_PATH/auth/sign-in"
        const val SIGN_UP_PATH = "$PRE_PATH/auth/sign-up"
    }
}