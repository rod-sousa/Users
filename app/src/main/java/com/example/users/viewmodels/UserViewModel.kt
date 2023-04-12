package com.example.users.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.model.User
import com.example.users.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val userList = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    //TODO - Coroutine (dispatchers)
    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        val response = userRepository.getAllUsers()
        if (response.isSuccessful) {
            userList.postValue(response.body())
        } else {
            Log.e("Erro", response.errorBody().toString())
            //errorMessage.postValue(response.message())
        }
        //TODO ERRO

        //TODO - Atualiza view, trata erro, LiveData

    }
}