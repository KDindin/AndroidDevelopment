package com.example.assignment1.repository

import com.example.assignment1.models.Book
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

const val BOOKS_COLLECTIONS_REF = "books"

class StorageRepository(){
    fun user() = Firebase.auth.currentUser
    fun hasUser():Boolean = Firebase.auth.currentUser != null

    fun getUserId():String = Firebase.auth.currentUser?.uid.orEmpty()

    private val booksRef: CollectionReference = Firebase
        .firestore.collection(BOOKS_COLLECTIONS_REF)

    fun getAllBooksInAscOrder():Flow<Resources<List<Book>>> = callbackFlow {
        var snapshotStateListener:ListenerRegistration? = null

        try{
            snapshotStateListener = booksRef
                .orderBy("cost")
                .addSnapshotListener{ snapshot, e ->
                    val response = if (snapshot != null){
                        val books = snapshot.toObjects(Book::class.java)
                        Resources.Success(data = books)
                    }
                    else{
                        Resources.Error(throwable = e?.cause)
                    }
                    trySend(response)
                }
        }catch(e:Exception){
            trySend(Resources.Error(e?.cause))
            e.printStackTrace()
        }

        awaitClose{
            snapshotStateListener?.remove()
        }
    }

    fun getBook(
        bookId: String,
        onError:(Throwable?) -> Unit,
        onSuccess: (Book?) -> Unit
    ){
        booksRef
            .document(bookId)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it?.toObject(Book::class.java))
            }
            .addOnFailureListener{ result ->
                onError.invoke(result.cause)
            }
    }

    fun addBook(
        title: String,
        description: String,
        cost: Int,
        onComplete: (Boolean) -> Unit,
    ){
        val documentId = booksRef.document().id
        val book = Book(
            title,
            description,
            cost,
            documentId = documentId
        )
        booksRef
            .document(documentId)
            .set(book)
            .addOnCompleteListener{ result ->
                onComplete.invoke(result.isSuccessful)
            }
    }

    fun deleteBook(
        bookId: String,
        onComplete: (Boolean) -> Unit
    ){
        booksRef.document(bookId)
            .delete()
            .addOnCompleteListener{
                onComplete.invoke(it.isSuccessful)
            }
    }

    fun updateBook(
        title: String,
        description: String,
        bookId: String,
        onResult: (Boolean) ->Unit
    ){
        val updateData = hashMapOf<String, Any>(
            "title" to title,
            "description" to description
        )

        booksRef.document(bookId)
            .update(updateData)
            .addOnCompleteListener{
                onResult(it.isSuccessful)
            }
    }

    fun signOut() = Firebase.auth.signOut()
}

sealed class Resources<T>(
    val data: T? = null,
    val throwable: Throwable?=null,
){
    class Loading<T>:Resources<T>()
    class Success<T>(data: T?): Resources<T>(data = data)
    class Error<T>(throwable: Throwable?): Resources<T>(throwable = throwable)
}
