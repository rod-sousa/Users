package com.example.users.repositories

import com.example.users.model.User

interface UserRepository {
    suspend fun getAllUsers(): List<User>
}