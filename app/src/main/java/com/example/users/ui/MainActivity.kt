package com.example.users.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.users.api.UserApi
import com.example.users.databinding.ActivityMainBinding
import com.example.users.repositories.UserRepositoryImpl
import com.example.users.viewmodels.UserViewModel
import com.example.users.viewmodels.factories.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    //TODO - Explicar by lazy e o porque do binding
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userApi = UserApi.getInstance()
        val userRepository = UserRepositoryImpl(userApi)

        val userViewModel = ViewModelProvider(
            this,
            UserViewModelFactory(userRepository)
        )[UserViewModel::class.java]

        binding.button.setOnClickListener{
            userViewModel.getAllUsers()
        }
    }
}