package com.example.applicationgastos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface GastosDAO {
//        @Transaction
//        @Query("SELECT * FROM gastos")
//        fun getAll(): List<GastosWithCategory>

        @Query ("SELECT gastos.*, category.category AS categoryName FROM gastos INNER JOIN category ON gastos.categoryID = category.categoryID ")
        fun getGastos(): List<GastosWithCategory>

        @Query ("SELECT gastos.*, category.category AS categoryName FROM gastos INNER JOIN category ON gastos.categoryID = category.categoryID WHERE category.categoryID = :categoryID")
        fun getGastosCategory(categoryID: Int): List<GastosWithCategory>

        @Insert
        suspend fun insertAll( gastos: Gastos)

        @Query("SELECT c.category AS nombre, SUM(g.monto) AS total FROM gastos AS g INNER JOIN category AS c ON g.categoryID = c.categoryID GROUP BY c.category ORDER BY total DESC")
        fun getCategoriaConMayorSuma(): List<CategoriaConSuma>
//        SELECT c.nombre, SUM(g.monto) AS total FROM gastos AS g INNER JOIN categoria AS c ON g.categoryID = c.id GROUP BY g.categoryID ORDER BY total DESC
//        SELECT c.category AS nombre, SUM(g.monto) AS total FROM gastos AS g INNER JOIN category AS c ON g.categoryID = c.categoryID GROUP BY g.categoryID ORDER BY total DESC LIMIT 1
        data class CategoriaConSuma(
                val nombre: String,
                val total: Double
        )
}