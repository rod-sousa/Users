package com.example.users.api

import com.example.users.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {

    // TODO - Explicar suspend fun
    @GET("/users")
    suspend fun getAllUsers() : List<User>

//    // TODO - singleton
//    companion object {
//        private var retrofitService: UserApi? = null
//
//        fun getInstance(): UserApi {
//
//            if(retrofitService == null){
//                val retrofit = Retrofit.Builder()
//                    .baseUrl("https://api.github.com/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//
//                //TODO - explicar ::class
//                retrofitService = retrofit.create(UserApi::class.java)
//            }
//            return retrofitService!!
//        }
//    }

}