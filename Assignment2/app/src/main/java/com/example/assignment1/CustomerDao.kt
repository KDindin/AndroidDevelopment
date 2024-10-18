package com.example.assignment1

import androidx.room.*

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customer_table")
    fun getAll(): List<Customer>

    @Query("SELECT * FROM customer_table WHERE login  LIKE :userName LIMIT 1")
    suspend fun findByLogin(userName: String):Customer

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(customer: Customer)

    @Update
    suspend fun update(customer: Customer)

    @Delete
    suspend fun delete(customer: Customer)

    @Query("DELETE FROM customer_table")
    suspend fun deleteAll()

}