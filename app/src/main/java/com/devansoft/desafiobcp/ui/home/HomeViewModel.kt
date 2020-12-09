package com.devansoft.desafiobcp.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.devansoft.desafiobcp.data.repositories.UserRepository
import com.devansoft.desafiobcp.utils.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}