package com.example.assignment1.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.assignment1.models.Book
import com.example.assignment1.repository.StorageRepository
import com.google.firebase.auth.FirebaseUser

class DetailViewModel(
    private val repository: StorageRepository = StorageRepository()
): ViewModel() {
    var detailUiState by mutableStateOf(DetailUiState())
        private set

    private val hasUser:Boolean
        get() = repository.hasUser()

    private val user:FirebaseUser?
        get() = repository.user()

    fun onTitleChange(title: String) {
        detailUiState = detailUiState.copy(title = title)
    }

    fun onDescriptionChange(description: String){
        detailUiState = detailUiState.copy(description = description)
    }


    fun addBook(){
        if (hasUser){
            repository.addBook(
                title = detailUiState.title,
                description = detailUiState.description,
                cost = detailUiState.cost
            ){
                detailUiState = detailUiState.copy(bookAddedStatus = it)
            }
        }
    }

    fun setEditFields(book:Book){
        detailUiState = detailUiState.copy(
            title = book.title,
            description = book.description
        )
    }

    fun getBook(bookId: String){
        repository.getBook(
            bookId = bookId,
            onError = {},
        ){
            detailUiState = detailUiState.copy(selectedBook = it)
            detailUiState.selectedBook?.let { it1 -> setEditFields(it1) }
        }
    }

    fun updateBook(
        bookId: String
    ){
        repository.updateBook(
            title = detailUiState.title,
            description = detailUiState.description,
            bookId = bookId
        ){
            detailUiState = detailUiState.copy(updateBookStatus = it)
        }
    }

    fun resetBookAddedStatus(){
        detailUiState = detailUiState.copy(
            bookAddedStatus = false,
            updateBookStatus = false,
        )
    }

    fun resetState(){
        detailUiState = DetailUiState()
    }


}

data class DetailUiState(
    val title:String = "",
    val description:String = "",
    val cost: Int = 0,
    val bookAddedStatus: Boolean = false,
    val updateBookStatus:Boolean = false,
    val selectedBook: Book?= null
)