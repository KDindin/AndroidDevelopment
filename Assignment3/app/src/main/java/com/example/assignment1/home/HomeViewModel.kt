package com.example.assignment1.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment1.models.Book
import com.example.assignment1.repository.Resources
import com.example.assignment1.repository.StorageRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: StorageRepository = StorageRepository()
):ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())

    val user = repository.user()

    val hasUser:Boolean
        get() = repository.hasUser()

    private val userId:String
        get() = repository.getUserId()

    fun loadBooks(){
        if(hasUser) {
            getAllBooksInAscOrder()
        }
        else{
            homeUiState = homeUiState.copy(booksList = Resources.Error(
                throwable = Throwable(message = "User is not logged in")
            ))
        }
    }

    private fun getAllBooksInAscOrder() = viewModelScope.launch {
        repository.getAllBooksInAscOrder().collect{
            homeUiState = homeUiState.copy(booksList = it)
        }
    }

    fun deleteBook(bookId:String) = repository.deleteBook(bookId){
        homeUiState = homeUiState.copy(bookDeletedStatus = it)
    }

    fun signOut() = repository.signOut()

}

data class HomeUiState(
    val booksList:Resources<List<Book>> = Resources.Loading(),
    val bookDeletedStatus:Boolean = false
)