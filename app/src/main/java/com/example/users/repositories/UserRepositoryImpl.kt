package com.example.users.repositories

import com.example.users.api.UserApi
import com.example.users.model.User
import retrofit2.Response

//TODO - Implementa interface explicar (facilita os teste unitarios)
//TODO - Repository é usado para abstrair as chamadas em um lugar só, caso mude - precisará mudar somente em um lugar
class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun getAllUsers(): Response<List<User>> = userApi.getAllUsers()

}