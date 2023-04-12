package com.example.users.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.users.databinding.ActivityMainBinding
import com.example.users.ui.adapters.MainAdapter
import com.example.users.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val userViewModel: UserViewModel by viewModel()

    private val adapter = MainAdapter { user ->
        createAlertDialog(user.html_url)
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

    override fun onStart() {
        super.onStart()

        userViewModel.userList.observe(this, Observer { users ->
            adapter.setUserList(users)
        })

        userViewModel.errorMessage.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
    }

    override fun onResume() {
        super.onResume()

        userViewModel.getAllUsers()
    }

    private fun openLink(link: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }

    private fun createAlertDialog(url: String) {
        AlertDialog.Builder(this)
            .setTitle("Abrir URL")
            .setMessage("Deseja sair do app e abrir Link?")
            .setPositiveButton("Sim") { _, _ ->
                openLink(url)
            }.setNegativeButton("Não") { _, _ -> }
            .show()
    }
}