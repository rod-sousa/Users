package com.example.users.di.modules

import com.example.users.api.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module{

    single {
        userApi()
    }

}

private fun userApi() = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(UserApi::class.java)