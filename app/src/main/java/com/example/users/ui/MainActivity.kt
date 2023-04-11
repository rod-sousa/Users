package com.example.users.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.users.api.UserApi
import com.example.users.databinding.ActivityMainBinding
import com.example.users.repositories.UserRepositoryImpl
import com.example.users.viewmodels.UserViewModel
import com.example.users.viewmodels.factories.UserViewModelFactory
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.get

class MainActivity : AppCompatActivity() {

    //TODO - Explicar by lazy e o porque do binding (by lazy  = uma forma de instanciar o obejto 1x só e qnd for utilizado)
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //TODO - by inject - só criará essa dependencia quando utilizar ele
    //private val userRepository: UserRepositoryImpl by inject()

    //TODO - by viewModel - injeta uma viewModel
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val userApi = UserApi.getInstance()
        //val userRepository = UserRepositoryImpl(userApi)

//        val userViewModel = ViewModelProvider(
//            this,
//            UserViewModelFactory(userRepository)
//        )[UserViewModel::class.java]

        binding.button.setOnClickListener{
            userViewModel.getAllUsers()
        }
    }
}