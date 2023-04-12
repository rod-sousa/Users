package com.example.users.api

import com.example.users.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET("/users")
    suspend fun getAllUsers() : Response<List<User>>

}