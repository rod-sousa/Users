package com.example.users.di.modules

import com.example.users.api.UserApi
import com.example.users.repositories.UserRepository
import com.example.users.repositories.UserRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {

    single<UserRepository> {
        provideUserRepository(userApi = get())
    }
}

private fun provideUserRepository(userApi: UserApi) =
    UserRepositoryImpl(
        userApi = userApi
    )