package com.example.users.repositories

import com.example.users.api.UserApi
import com.example.users.model.User
import retrofit2.Response

class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun getAllUsers(): Response<List<User>> = userApi.getAllUsers()

}