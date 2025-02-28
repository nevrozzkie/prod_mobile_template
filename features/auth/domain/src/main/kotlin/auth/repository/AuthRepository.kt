package auth.repository

interface AuthRepository {
    suspend fun signIn()
    suspend fun signUp()
}