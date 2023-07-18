package com.example.applicationgastos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDAO {
        @Query("SELECT * FROM category")
        fun getAll(): List<Category>

        @Insert
        suspend fun insertAll( categories: Category)
}