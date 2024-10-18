package com.example.assignment1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class Customer(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "login") val login: String?,
    @ColumnInfo(name = "password") val password: String?
)
