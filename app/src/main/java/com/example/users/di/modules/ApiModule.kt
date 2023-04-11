package com.example.users.di.modules

import com.example.users.api.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO explicar os modulos (ensinando ao Koin como criar as minhas dependencias)
val apiModule = module{
    //TODO - Singleton uma instancia sempre // Factory uma nova instancia sempre que for chamado

    //TODO Quero que seja uma instancia singleton
    single {
        userApi()
    }

}

//TODO - explicar ::class
private fun userApi() = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(UserApi::class.java)