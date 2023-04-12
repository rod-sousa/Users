package com.example.users.repositories

import com.example.users.api.UserApi
import com.example.users.model.User
import retrofit2.Call
import retrofit2.Response

//TODO - Implementa interface explicar (facilita os teste unitarios)
class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun getAllUsers(): Response<List<User>> = userApi.getAllUsers()

}