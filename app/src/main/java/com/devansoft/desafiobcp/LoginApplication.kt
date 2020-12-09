package com.devansoft.desafiobcp

import android.app.Application
import com.devansoft.desafiobcp.data.firebase.FirebaseSource
import com.devansoft.desafiobcp.data.repositories.UserRepository
import com.devansoft.desafiobcp.ui.auth.AuthViewModelFactory
import com.devansoft.desafiobcp.ui.home.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class LoginApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@LoginApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }

    }
}