package com.example.applicationgastos

import android.location.Address
import androidx.room.ColumnInfo
import androidx.room.Embedded
import  androidx.room.Entity
import androidx.room.Relation
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class GastosWithCategory (
    @Embedded var gastos: Gastos,
    @ColumnInfo(name = "categoryName") val category: String

)
