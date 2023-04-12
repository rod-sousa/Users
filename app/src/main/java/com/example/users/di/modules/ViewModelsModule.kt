package com.example.users.di.modules

import com.example.users.repositories.UserRepository
import com.example.users.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    //TODO - O koin vai criar o factory do viewModel
    viewModel {
        provideUserViewModel(userRepository = get())
    }
}

fun provideUserViewModel(userRepository: UserRepository): UserViewModel {
    return UserViewModel(userRepository)
}