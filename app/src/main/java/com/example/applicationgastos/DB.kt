package com.example.applicationgastos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1
)
abstract class DB: RoomDatabase(){
    abstract fun daoUser():UserDAO
}