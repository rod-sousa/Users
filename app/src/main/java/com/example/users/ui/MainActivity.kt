package com.example.users.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.users.api.UserApi
import com.example.users.databinding.ActivityMainBinding
import com.example.users.repositories.UserRepositoryImpl
import com.example.users.ui.adapters.MainAdapter
import com.example.users.viewmodels.UserViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.get

class MainActivity : AppCompatActivity() {

    //TODO - Explicar by lazy e o porque do binding (by lazy  = uma forma de instanciar o obejto 1x só e qnd for utilizado)
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater) }

    //TODO - by viewModel - injeta uma viewModel (koin)
    private val userViewModel: UserViewModel by viewModel()

    private val adapter = MainAdapter{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val userApi = UserApi.getInstance()
        //val userRepository = UserRepositoryImpl(userApi)

//        val userViewModel = ViewModelProvider(
//            this,
//            UserViewModelFactory(userRepository)
//        )[UserViewModel::class.java]

        /////////////////////////
        //binding.button.setOnClickListener{
        //    userViewModel.getAllUsers()
        //}

        binding.rvUsers.adapter = adapter

    }

    //TODO - Ciclo de vida
    override fun onStart() {
        super.onStart()

        userViewModel.userList.observe(this, Observer{ users ->
            adapter.setUserList(users)
        })

        userViewModel.errorMessage.observe(this, Observer{error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
    }

    //TODO - Toda vez que entrar na tela atualiza
    override fun onResume() {
        super.onResume()

        userViewModel.getAllUsers()
    }

    //TODO - Fragment (modal)
    private fun openLink(link: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }
}