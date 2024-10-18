package com.example.assignment1

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomerViewModel (application: Application): AndroidViewModel(application){
    private val userList : LiveData<List<Customer>>
    private val usersRepository: CustomerRepository

    init {
        val userDao = AppDatabase.getDatabase(application).customerDao()
        usersRepository = CustomerRepository(userDao)
        userList = usersRepository.allUsers

    }

    fun addUser(user: Customer){
        viewModelScope.launch(Dispatchers.IO) {
            usersRepository.insertUser(user)
        }
    }

    fun findUserByUsername(userName:String) : MutableLiveData<Customer> {
        viewModelScope.launch(Dispatchers.IO) {
            usersRepository.getUser(userName)
        }
        return usersRepository.foundUser
    }
}