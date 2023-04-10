package com.example.users.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.users.viewmodels.UserViewModel
import com.example.users.repositories.UserRepository

class UserViewModelFactory (private val repository: UserRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserViewModel::class.java)){
            UserViewModel(this.repository) as T
        } else
            throw IllegalArgumentException("ViewModel Not Found")
    }
}