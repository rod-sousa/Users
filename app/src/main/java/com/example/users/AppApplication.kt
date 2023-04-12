package com.example.users

import android.app.Application
import com.example.users.di.modules.apiModule
import com.example.users.di.modules.repositoriesModule
import com.example.users.di.modules.viewModelsModule
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                apiModule,
                repositoriesModule,
                viewModelsModule
            )
        }
    }
}