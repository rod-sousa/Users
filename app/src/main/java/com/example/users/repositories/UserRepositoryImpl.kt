package com.example.users.repositories

import com.example.users.api.UserApi
import com.example.users.model.User

//TODO - Implementa interface explicar (facilita os teste unitarios)
class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun getAllUsers(): List<User> = userApi.getAllUsers()

}