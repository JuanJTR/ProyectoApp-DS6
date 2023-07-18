package com.example.applicationgastos

import androidx.room.ColumnInfo
import  androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Gastos {
    @PrimaryKey(autoGenerate = true)
    var gastosID:Int = 0
    @ColumnInfo(name = "categoryID") val categoryID: Int
    var monto: Double?
    var fecha: String?
    var descripcion: String?
    constructor(categoryID: Int, monto:Double, fecha:String, descripcion: String){
        this.categoryID = categoryID
        this.monto = monto
        this.fecha =  fecha
        this.descripcion = descripcion
    }
}