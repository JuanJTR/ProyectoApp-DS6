package com.example.applicationgastos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
        @Query("SELECT * FROM user")
        fun getAll(): List<User>

        @Insert
        suspend fun insertAll( users: User)
}