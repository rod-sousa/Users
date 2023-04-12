package com.example.users.repositories

import com.example.users.model.User
import retrofit2.Call
import retrofit2.Response

interface UserRepository {
    suspend fun getAllUsers(): Response<List<User>>
}