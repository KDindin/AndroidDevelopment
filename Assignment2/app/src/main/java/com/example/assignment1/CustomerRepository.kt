package com.example.assignment1

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CustomerRepository(private val customerDao: CustomerDao) {
    val allUsers = MutableLiveData<List<Customer>>()
    val foundUser = MutableLiveData<Customer>()


    suspend fun getAllUsers(){
        allUsers.postValue(customerDao.getAll())
    }

    suspend fun getUser(email: String) {
        return foundUser.postValue(customerDao.findByLogin(email))
    }

    suspend fun insertUser(user: Customer){
        customerDao.insert(user)

    }
}