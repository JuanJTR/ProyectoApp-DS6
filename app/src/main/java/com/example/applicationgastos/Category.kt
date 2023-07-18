package com.example.applicationgastos

import  androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Category {

    @PrimaryKey(autoGenerate = true)
    var categoryID:Int = 0
    var category: String?
    constructor(category: String){
        this.category = category
    }
}