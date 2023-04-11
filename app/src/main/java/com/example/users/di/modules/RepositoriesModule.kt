package com.example.users.di.modules

import com.example.users.api.UserApi
import com.example.users.repositories.UserRepository
import com.example.users.repositories.UserRepositoryImpl
import org.koin.core.scope.Scope
import org.koin.dsl.module

//TODO - Ensinando o Koin a criar minhas dependencias
val repositoriesModule = module {

    single<UserRepository> {
        //TODO - Já que ensinei ao Koin como criar um userApi, só chamando o get() ele já vai saber qual injetar
        provideUserRepository(userApi = get())
    }
}

private fun provideUserRepository(userApi : UserApi) =
    UserRepositoryImpl(
        userApi = userApi
    )