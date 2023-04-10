package com.example.users.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    fun getAllUsers() = viewModelScope.launch {
        val users = userRepository.getAllUsers()

        //TODO - Atualiza view, trata erro, LiveData
        for(user in users){
            Log.i("Rodrigo", user.login)
        }
    }
}