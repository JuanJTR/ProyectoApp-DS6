package com.example.applicationgastos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface GastosDAO {
//        @Transaction
//        @Query("SELECT * FROM gastos")
//        fun getAll(): List<GastosWithCategory>

        @Query ("SELECT gastos.*, category.category AS categoryName FROM gastos INNER JOIN category ON gastos.categoryID = category.categoryID")
        fun getGastos(): List<GastosWithCategory>
        @Insert
        suspend fun insertAll( gastos: Gastos)
}